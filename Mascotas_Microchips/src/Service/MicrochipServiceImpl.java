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
        // eliminación lógica en el DAO (Eliminado = true)
        microchipDao.eliminar(id);
    }

    // Buscar por código específico (usa método propio del DAO concreto)
    public Microchip findByCodigo(String codigo) throws Exception {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }
        return microchipDaoImpl.buscarPorCodigo(codigo);
    }

    /**
     * Método transaccional simple para guardar un microchip.
     * Acá NO se valida la relación 1→1 con Mascota porque
     * ahora la FK está en Mascota (Id_microchip) y esa regla
     * se controla en MascotaServiceImpl.
     */
    @Override
    public void saveTx(Microchip entity) throws Exception {
        validarMicrochip(entity);

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
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
            // Podés loguearlo si querés, pero lo relanzamos
            throw e;
        }
    }

    // Validaciones de negocio para Microchip
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
        // Ya NO validamos idMascota porque el modelo nuevo
        // no tiene ese campo en Microchip.
    }
}
