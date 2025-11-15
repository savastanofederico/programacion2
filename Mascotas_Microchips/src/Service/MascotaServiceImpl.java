package Service;

import Dao.GenericDao;
import Daoimplement.MascotaDao;
import Daoimplement.MicrochipDao;
import config.DatabaseConnection;
import entities.Mascota;
import entities.Microchip;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MascotaServiceImpl implements GenericService<Mascota> {

    private final GenericDao<Mascota> mascotaDao;
    private final MascotaDao mascotaDaoImpl;
    private final MicrochipDao microchipDaoImpl;

    public MascotaServiceImpl(GenericDao<Mascota> mascotaDao, MicrochipDao microchipDao) {
        this.mascotaDao = mascotaDao;
        this.mascotaDaoImpl = (MascotaDao) mascotaDao;
        this.microchipDaoImpl = microchipDao;
    }

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
            throw new IllegalArgumentException("La mascota debe tener ID.");
        }
        mascotaDao.actualizar(entity);
    }

    @Override
    public void delete(long id) throws Exception {
        mascotaDao.eliminar(id);
    }

    // ---------------------------------------
    //  TRANSACCIÓN: Mascota + Microchip
    // ---------------------------------------

    @Override
    public void saveTx(Mascota entity) throws Exception {
        validarMascota(entity);

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            Mascota m = entity;

            // 1) Crear mascota
            mascotaDaoImpl.crear(m, conn);
            Long idMascota = m.getId();

            Microchip chip = m.getMicrochip();

            if (chip != null) {

                validarMicrochip(chip);

                if (mascotaDaoImpl.tieneMicrochip(idMascota, conn)) {
                    throw new IllegalStateException("La mascota ya tiene un microchip asignado (1 a 1).");
                }

                microchipDaoImpl.crear(chip, conn);
                Long idChip = chip.getId();

                mascotaDaoImpl.actualizarMicrochip(idMascota, idChip, conn);
            }

            conn.commit();

        } catch (Exception e) {
            throw e;
        }
    }


    // ---------------------------------------
    // ASIGNAR CHIP A UNA MASCOTA YA EXISTENTE
    // ---------------------------------------

    public void asignarMicrochipTx(long idMascota, Microchip chip) throws Exception {

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            // 1) Verificar existencia
            Mascota mascota = mascotaDaoImpl.leer(idMascota);
            if (mascota == null) {
                throw new IllegalArgumentException("No existe mascota con ID " + idMascota);
            }

            // 2) Regla 1 a 1
            if (mascotaDaoImpl.tieneMicrochip(idMascota, conn)) {
                throw new IllegalStateException("La mascota ya tiene un microchip asignado (1 a 1).");
            }

            // 3) Validación del microchip
            validarMicrochip(chip);

            // 4) Crear chip
            microchipDaoImpl.crear(chip, conn);
            Long idChip = chip.getId();

            // 5) Asociarlo
            mascotaDaoImpl.actualizarMicrochip(idMascota, idChip, conn);

            conn.commit();

        } catch (Exception e) {
            throw e;
        }
    }


    // ------------------------------
    // VALIDACIONES
    // ------------------------------

    private void validarMascota(Mascota m) {
        if (m == null) throw new IllegalArgumentException("La mascota no puede ser null.");
        if (m.getNombre() == null || m.getNombre().isBlank())
            throw new IllegalArgumentException("La mascota debe tener nombre.");
        if (m.getEspecie() == null)
            throw new IllegalArgumentException("La mascota debe tener especie.");
    }

    private void validarMicrochip(Microchip c) {
        if (c == null) throw new IllegalArgumentException("El microchip no puede ser null.");
        if (c.getCodigo() == null || c.getCodigo().isBlank())
            throw new IllegalArgumentException("El código del microchip es obligatorio.");
        if (c.getFechaImplantacion() == null)
            throw new IllegalArgumentException("La fecha de implantación es obligatoria.");
    }
}
