/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daoimplement;

import Dao.GenericDao;
import config.DatabaseConnection;

import entities.Mascota;
import entities.Microchip;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MascotaDao implements GenericDao<Mascota> {

    private MicrochipDao microchipDao = new MicrochipDao();

    @Override
    public void crear(Mascota mascota) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            crear(mascota, conn);
        }
    }

    @Override
    public void crear(Mascota m, Connection conn) throws SQLException {
        String sql = "INSERT INTO Mascota (Nombre, Especie, Raza, FechaNacimiento, Duenio, Eliminado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setDate(4, Date.valueOf(m.getFechaNacimiento()));
            ps.setString(5, m.getDuenio());
            ps.setBoolean(6, m.getEliminado());
            //   ps.setObject(7, m.getMicrochip() != null ? m.getMicrochip().getId() : null);

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    m.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Mascota leer(long id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Mascota WHERE id = ? AND eliminado = false";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Mascota m = mapMascota(rs);

                        // Leer el Id_microchip desde el ResultSet
                        Long idChip = rs.getLong("id_microchip");

                        if (!rs.wasNull()) {
                            Microchip chip = microchipDao.leer(idChip);
                            m.setMicrochip(chip);
                        }
                        return m;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Mascota> leerTodos() throws SQLException {
        List<Mascota> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM Mascota WHERE eliminado = false")) {

            while (rs.next()) {
                Mascota m = mapMascota(rs);

                // Leer el Id_microchip desde el ResultSet
                Long idChip = rs.getLong("id_microchip");

                if (!rs.wasNull()) {
                    Microchip chip = microchipDao.leer(idChip); // Usa el método que abre su propia conexión
                    m.setMicrochip(chip);
                }
                lista.add(m);
            }
        }
        return lista;
    }

    @Override
    public void actualizar(Mascota mascota) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            actualizar(mascota, conn);
        }
    }

    @Override
    public void actualizar(Mascota mascota, Connection conn) throws SQLException {
        String sql = """
            UPDATE Mascota
            SET eliminado=?, nombre=?, especie=?, raza=?, fechaNacimiento=?, duenio=?
            WHERE id=?
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, mascota.getEliminado() != null ? mascota.getEliminado() : false);
            ps.setString(2, mascota.getNombre());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setDate(5, mascota.getFechaNacimiento() != null ? Date.valueOf(mascota.getFechaNacimiento()) : null);
            ps.setString(6, mascota.getDuenio());
            ps.setLong(7, mascota.getId());
            ps.executeUpdate();
        }

        if (mascota.getMicrochip() != null) {

            microchipDao.actualizar(mascota.getMicrochip(), conn);
        }
    }

    @Override
    public void eliminar(long id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            eliminar(id, conn);
        }
    }

    @Override
    public void eliminar(long id, Connection conn) throws SQLException {
        // Eliminado lógico
        String sql = "UPDATE Mascota SET eliminado = true WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    private Mascota mapMascota(ResultSet rs) throws SQLException {
        Mascota m = new Mascota();
        m.setId(rs.getLong("id"));
        m.setEliminado(rs.getBoolean("eliminado"));
        m.setNombre(rs.getString("nombre"));
        m.setEspecie(rs.getString("especie"));
        m.setRaza(rs.getString("raza"));
        Date fecha = rs.getDate("fechaNacimiento");
        if (fecha != null) {
            m.setFechaNacimiento(fecha.toLocalDate());
        }
        m.setDuenio(rs.getString("duenio"));

        Long idChip = rs.getObject("Id_microchip", Long.class);
        if (idChip != null) {
            Microchip chip = microchipDao.leer(idChip);  // ✅ sin conn
            m.setMicrochip(chip);
        }

        return m;
    }
    //Saber si una mascota tiene chip

    public boolean tieneMicrochip(long idMascota, Connection conn) throws SQLException {
        String sql = "SELECT Id_microchip FROM Mascota WHERE Id = ? AND Eliminado = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Long idChip = rs.getObject("Id_microchip", Long.class);
                    return idChip != null;
                }
                return false;
            }
        }
    }

    public void actualizarMicrochip(long idMascota, long idMicrochip, Connection conn) throws SQLException {
        String sql = "UPDATE Mascota SET Id_microchip = ? WHERE Id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idMicrochip);
            ps.setLong(2, idMascota);
            ps.executeUpdate();
        }
    }

}
