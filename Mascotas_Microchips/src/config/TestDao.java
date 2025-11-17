/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import Daoimplement.MascotaDao;
import Daoimplement.MicrochipDao;
import entities.Mascota;
import entities.Microchip;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestDao {

    public static void main(String[] args) {
       
       MascotaDao mascotaDao = new MascotaDao();
        MicrochipDao microchipDao = new MicrochipDao();

        // declaré las entidades fuera de cualquier bloque try-catch.
        Microchip chip = null;
        Mascota m = new Mascota();
        
        // Bloque 1: Transacción para la CREACIÓN (usa conexión transaccional)
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); 

            // Crear un microchip
            chip = new Microchip(
                    null, false,
                    "CHIP-" + System.currentTimeMillis(),
                    LocalDate.of(2025, 1, 1),
                    "VetPlus",
                    "Implantado correctamente",
                    1L
            );

            microchipDao.crear(chip, conn);

            // Crear y setear la mascota 'm'
            m.setNombre("Luna");
            m.setEspecie("PERRO"); 
            m.setRaza("Labrador");
            m.setFechaNacimiento(LocalDate.of(2020, 5, 15));
            m.setDuenio("María Pérez");
            m.setMicrochip(chip);
            m.setEliminado(false);

            // Esto llama a m.setId() con el ID generado, y 'm' es accesible afuera
            mascotaDao.crear(m, conn);

            conn.commit(); 
            
            System.out.println("Mascota y microchip creados con éxito");
            } catch (SQLException e) {
            System.err.println("Error en la transacción de creación: ");
            e.printStackTrace();
            return; // Salir si la creación falla.
        }
        
        // Bloque 2: Operaciones INDEPENDIENTES (Usando las IDs generadas)
        // Solo se ejecuta si la mascota se creó con un ID válido.
        if (m.getId() > 0) {
            try {
                // Leer la mascota (usa su propia conexión interna)
                Mascota mascotaLeida = mascotaDao.leer(m.getId());
                System.out.println("Mascota leída: " + mascotaLeida);

                // Actualizar (usa su propia conexión interna)
                if (mascotaLeida != null) {
                    mascotaLeida.setRaza("Golden Retriever");
                    mascotaDao.actualizar(mascotaLeida); 
                    System.out.println("Mascota actualizada.");
                }

                // Leer todas (usa su propia conexión interna)
                System.out.println("Todas las mascotas:");
                for (Mascota masc : mascotaDao.leerTodos()) {
                    System.out.println(masc);
                }

                // Eliminar logico (usa su propia conexión interna)
                if (mascotaLeida != null) {
                    mascotaDao.eliminar(mascotaLeida.getId());
                    System.out.println("Mascota marcada como eliminada.");
                }

            } catch (SQLException e) {
                System.err.println("Error en operaciones de lectura o actualización: ");
                e.printStackTrace();
            }
        } else {
             System.out.println("No se pudo continuar con las operaciones de lectura o actualización porque la creación inicial falló o el ID es inválido.");
        }
    }
    }

