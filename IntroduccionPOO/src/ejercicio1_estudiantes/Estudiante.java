/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_estudiantes;

/**
 *
 * @author federico
 */
public class Estudiante {

    String nombre;
    String apellido;
    String curso;
    double calificacion;

    // Inicia objeto
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    // Métodos
    public void mostrarInfo() {
        System.out.println("Información del estudiante");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Curso: " + this.curso);
        System.out.println("Calificación: " + this.calificacion);
    }

    public void subirCalificacion(double puntos) {
        this.calificacion += puntos;
        System.out.println("La calificación de " + this.nombre + " subió a " + this.calificacion);
    }

    public void bajarCalificacion(double puntos) {
        this.calificacion -= puntos;
        System.out.println("La calificación de " + this.nombre + " bajó a " + this.calificacion);
    }
}