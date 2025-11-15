package Service;

import Dao.GenericDao;
import Daoimplement.MascotaDao;
import Daoimplement.MicrochipDao;
import config.DatabaseConnection;
import entities.Mascota;
import entities.Microchip;

import java.sql.Connection;

import java.util.List;

public class MascotaServiceImpl implements GenericService<Mascota> {

    private final GenericDao<Mascota> mascotaDao;
    private final MascotaDao mascotaDaoImpl;     // para usar los métodos con Connection
    private final MicrochipDao microchipDao;     // para operaciones con B en la misma Tx

    public MascotaServiceImpl(GenericDao<Mascota> mascotaDao) {
        this.mascotaDao = mascotaDao;
        this.mascotaDaoImpl = (MascotaDao) mascotaDao;
        this.microchipDao = new MicrochipDao();
    }

    // Operaciones CRUD simples

    @Override
    public void save(Mascota entity) throws Exception {
        validarMascota(entity);
        mascotaDao.crear(entity);
    }

    @Override
    public Mascota findById(long id) throws Exception {
        return mascotaDao.leer(id);
    }

    @Override
    public List<Mascota> findAll() throws Exception {
        return mascotaDao.leerTodos();
    }

    @Override
    public void update(Mascota entity) throws Exception {
        validarMascota(entity);
        if (entity.getId() == null) {
            throw new IllegalArgumentException("La mascota debe tener ID para actualizarse.");
        }
        mascotaDao.actualizar(entity);
    }

    @Override
    public void delete(long id) throws Exception {
        mascotaDao.eliminar(id); // eliminado lógico
    }

    
    /**
     * Transacción: Guarda una Mascota y, si tiene un Microchip asociado (entity.getMicrochip() != null),
     * también crea el Microchip en la misma transacción.
     *
     */
    @Override
    public void saveTx(Mascota entity) throws Exception {
        validarMascota(entity);
        Microchip chip = entity.getMicrochip();  // B asociado a A

        // Si no hay chip, podés decidir: o solo crea A en Tx, o lanzar error 
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // 1) Crear Mascota con la conexión compartida
                mascotaDaoImpl.crear(entity, conn);  
                Long idMascota = entity.getId();

              
                if (chip != null) {
                    validarMicrochip(chip);

                    
                    if (microchipDao.existeChipParaMascota(idMascota, conn)) {
                        throw new IllegalStateException(
                            "La mascota con ID " + idMascota + " ya tiene un microchip asignado (regla 1→1).");
                    }

                    // Asociar el chip a la mascota
                    chip.setIdMascota(idMascota);
                    microchipDao.crear(chip, conn);
                }

                conn.commit();
            } catch (Exception ex) {
                conn.rollback();          // rollback ante cualquier error
                throw ex;                 
            } finally {
                conn.setAutoCommit(true); // restablecer
            }
        }
    }

    // Validaciones

    private void validarMascota(Mascota m) {
        if (m == null) {
            throw new IllegalArgumentException("La mascota no puede ser null.");
        }
        if (m.getNombre() == null || m.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la mascota es obligatorio.");
        }
        if (m.getEspecie() == null || m.getEspecie().isBlank()) {
            throw new IllegalArgumentException("La especie es obligatoria.");
        }
        if (m.getDuenio() == null || m.getDuenio().isBlank()) {
            throw new IllegalArgumentException("El nombre del dueño es obligatorio.");
        }
      
    }

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
    }
}


