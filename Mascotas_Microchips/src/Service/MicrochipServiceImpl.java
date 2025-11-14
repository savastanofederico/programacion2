package Service;

import Dao.GenericDao;
import Daoimplement.MicrochipDao;
import config.DatabaseConnection;
import entities.Microchip;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class MicrochipServiceImpl implements GenericService<Microchip> {

    private final GenericDao<Microchip> microchipDao;
    private final MicrochipDao microchipDaoImpl;   // para usar métodos específicos con Connection

    public MicrochipServiceImpl(GenericDao<Microchip> microchipDao) {
        this.microchipDao = microchipDao;
        this.microchipDaoImpl = (MicrochipDao) microchipDao;
    }

    
    @Override
    public void save(Microchip entity) throws Exception {
        validarMicrochip(entity);
        microchipDao.crear(entity);
    }

    @Override
    public Microchip findById(long id) throws Exception {
        return microchipDao.leer(id);
    }

    @Override
    public List<Microchip> findAll() throws Exception {
        return microchipDao.leerTodos();
    }

    @Override
    public void update(Microchip entity) throws Exception {
        validarMicrochip(entity);
        if (entity.getId() == null) {
            throw new IllegalArgumentException("El microchip debe tener ID para actualizarse.");
        }
        microchipDao.actualizar(entity);
    }

    @Override
    public void delete(long id) throws Exception {
        microchipDao.eliminar(id);   // eliminación lógica en el DAO (Eliminado = true)

    }

    public Microchip findByCodigo(String codigo) throws Exception {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }
        return microchipDaoImpl.buscarPorCodigo(codigo);
    }

  
    
    /**
     * Método transaccional que guarda un microchip en una transacción explícita: - setAutoCommit(false)
     * sobre una conexión compartida 
     * - Si todo OK entonces commit() - Ante error : rollback()
     */
    @Override
    public void saveTx(Microchip entity) throws Exception {
        validarMicrochip(entity); // validar campos obligatorios y idMascota

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // Regla 1 → 1: la mascota no puede tener más de un microchip
                if (microchipDaoImpl.existeChipParaMascota(entity.getIdMascota(), conn)) {
                    throw new IllegalStateException(
                            "La mascota con ID " + entity.getIdMascota()
                            + " ya tiene un microchip asignado (regla 1→1).");
                }

                // Crear el microchip usando la misma conexión transaccional
                microchipDaoImpl.crear(entity, conn);

                conn.commit();
            } catch (Exception e) {
                conn.rollback();  // rollback ante cualquier problema
                throw e;
            } finally {
                conn.setAutoCommit(true);  // restaurar configuración
            }
        } catch (SQLException e) {
            
            throw e;
        }
    }


    // Validaciones
   
    private void validarMicrochip(Microchip c) {
        if (c == null) {
            throw new IllegalArgumentException("El microchip no puede ser null.");
        }
        if (c.getCodigo() == null || c.getCodigo().isBlank()) {
            throw new IllegalArgumentException("El código del microchip es obligatorio.");
        }
        if (c.getFechaImplantacion() == null) {
            throw new IllegalArgumentException("La fecha de implantación del microchip es obligatoria.");
        }
        if (c.getIdMascota() == null) {
            throw new IllegalArgumentException("El microchip debe estar asociado a una mascota (idMascota obligatorio).");
        }
    }
}
