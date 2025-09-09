/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3_libros;

/**
 *
 * @author federico
 */
public class Main {
    public static void main(String[] args) {
        
        Libro elPerfume = new Libro("El perfume", "Patrick Süskind", 1985);

        // Información inicial
        elPerfume.mostrarInfo();

        // Modifico con un valor inválido
        System.out.println("\nIntentando cambiar el año a 1800...");
        elPerfume.setAnioPublicacion(1800);

        // Modifico con un valor válido
        System.out.println("\nIntentando cambiar el año a 1986...");
        elPerfume.setAnioPublicacion(1986);

        // Información final
        System.out.println("\nInformación final del libro");
        System.out.println("Título: " + elPerfume.getTitulo());
        System.out.println("Autor: " + elPerfume.getAutor());
        System.out.println("Año de publicación: " + elPerfume.getAnioPublicacion());
    }
}
