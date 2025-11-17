/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daoimplement;

import Dao.GenericDao;
import config.DatabaseConnection;

import entities.Microchip;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MicrochipDao implements GenericDao<Microchip> {

    @Override
    public void crear(Microchip chip) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            crear(chip, conn);
        }
    }

    @Override
    public void crear(Microchip chip, Connection conn) throws SQLException {
        String sql = """
            INSERT INTO Microchip (eliminado, codigo, observaciones, veterinaria, fechaImplantacion)
            VALUES (?, ?, ?, ?, ? )
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setBoolean(1, chip.getEliminado() != null ? chip.getEliminado() : false);
            ps.setString(2, chip.getCodigo());
            ps.setString(3, chip.getObservaciones());
            ps.setString(4, chip.getVeterinaria());
            ps.setDate(5, chip.getFechaImplantacion() != null ? Date.valueOf(chip.getFechaImplantacion()) : null);
        //    ps.setLong(6, chip.getIdMascota());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    chip.setId(rs.getLong(1));
                }
            }
        }
    }

    @Override
    public Microchip leer(long id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Microchip WHERE id = ? AND eliminado = 0";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return mapMicrochip(rs);
                }
            }
        }
        return null;
    }

    public Microchip leerPorMascotaId(long mascotaId, Connection conn) throws SQLException {
        String sql = "SELECT m.* FROM Microchip m "
                + "INNER JOIN Mascota ma ON m.Id = ma.Id_microchip "
                + "WHERE ma.Id = ? AND m.Eliminado = false AND ma.Eliminado = false";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, mascotaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapMicrochip(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Microchip> leerTodos() throws SQLException {
        List<Microchip> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM Microchip WHERE eliminado = false")) {
            while (rs.next()) {
                lista.add(mapMicrochip(rs));
            }
        }
        return lista;
    }

    @Override
    public void actualizar(Microchip chip) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            actualizar(chip, conn);
        }
    }

    @Override
    public void actualizar(Microchip chip, Connection conn) throws SQLException {
        String sql = """
            UPDATE Microchip
            SET eliminado=?, codigo=?, observaciones=?, veterinaria=?, fechaImplantacion=?
            WHERE id=?
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, chip.getEliminado() != null ? chip.getEliminado() : false);
            ps.setString(2, chip.getCodigo());
            ps.setString(3, chip.getObservaciones());
            ps.setString(4, chip.getVeterinaria());
            ps.setDate(5, chip.getFechaImplantacion() != null ? Date.valueOf(chip.getFechaImplantacion()) : null);
            ps.setLong(6, chip.getId());
            ps.executeUpdate();
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
        String sql = "UPDATE Microchip SET eliminado = true WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    private Microchip mapMicrochip(ResultSet rs) throws SQLException {
        Microchip m = new Microchip();
        m.setId(rs.getLong("id"));
        m.setEliminado(rs.getBoolean("eliminado"));
        m.setCodigo(rs.getString("codigo"));
        m.setObservaciones(rs.getString("observaciones"));
        m.setVeterinaria(rs.getString("veterinaria"));
      //  Long idMascota = rs.getObject("Id_Mascota", Long.class);
        //m.setIdMascota(idMascota);
        Date fecha = rs.getDate("fechaImplantacion");
        if (fecha != null) {
            m.setFechaImplantacion(fecha.toLocalDate());
        }
        return m;
    }

    public boolean existeChipParaMascota(long idMascota, Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Microchip WHERE Id_mascota = ? AND Eliminado = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        }
    }

    // Buscar un microchip por su código 
    public Microchip buscarPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM Microchip WHERE Codigo = ? AND Eliminado = 0";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Microchip c = new Microchip();
                    c.setId(rs.getLong("Id"));
                    c.setEliminado(rs.getBoolean("Eliminado"));
                    c.setCodigo(rs.getString("Codigo"));
                    c.setObservaciones(rs.getString("Observaciones"));
                    c.setVeterinaria(rs.getString("veterinaria"));
                    c.setFechaImplantacion(rs.getDate("fechaImplantacion").toLocalDate());
                    //c.setIdMascota(rs.getLong("Id_mascota"));
                    return c;
                }
                return null;
            }
        }
    }

}
