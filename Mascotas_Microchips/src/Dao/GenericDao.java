/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {

    // Con conexión propia (abre y cierra)
    void crear(T entidad) throws SQLException;

    T leer(long id) throws SQLException;

    List<T> leerTodos() throws SQLException;

    void actualizar(T entidad) throws SQLException;

    void eliminar(long id) throws SQLException;

    // Con conexión externa (participa en transacción)
    void crear(T entidad, Connection conn) throws SQLException;

    void actualizar(T entidad, Connection conn) throws SQLException;

    void eliminar(long id, Connection conn) throws SQLException;
}
