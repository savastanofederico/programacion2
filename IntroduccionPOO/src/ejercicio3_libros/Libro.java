/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3_libros;

/**
 *
 * @author federico
 */
public class Libro {
  
    private String titulo;
    private String autor;
    private int anioPublicacion;

 
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.setAnioPublicacion(anioPublicacion); // Usamos el setter para la validación inicial
    }

    // Getters
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnioPublicacion() {
        return this.anioPublicacion;
    }

    // Setter con validación
    public void setAnioPublicacion(int anio) {
        if (anio > 0 && anio <= 2025) { // Ejemplo de validación
            this.anioPublicacion = anio;
            System.out.println("Año de publicación actualizado a " + anio);
        } else {
            System.out.println("Error: el año de publicación no es válido. No se realizó el cambio");
        }
    }

    public void mostrarInfo() {
        System.out.println("Información del Libro");
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Año de publicación: " + this.anioPublicacion);
    }
}
