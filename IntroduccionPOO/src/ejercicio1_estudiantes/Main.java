/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_estudiantes;

/**
 *
 * @author federico
 */
public class Main {
    public static void main(String[] args) {
      
        Estudiante estudiante = new Estudiante("Federico", "Savastano", "Programacion 2", 8.0);

        // Información inicial
        estudiante.mostrarInfo();

        // Aumenta calificación
        estudiante.subirCalificacion(1.5);

        // Disminuye calificación
        estudiante.bajarCalificacion(0.5);
        
        // Información final
        estudiante.mostrarInfo();
    }
}