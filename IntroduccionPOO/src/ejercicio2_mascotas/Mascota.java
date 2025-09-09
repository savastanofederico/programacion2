/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2_mascotas;

/**
 *
 * @author federico
 */
public class Mascota {
 
    String nombre;
    String especie;
    int edad;

  
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    // Métodos
    public void mostrarInfo() {
        System.out.println("Información de la mascota");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Especie: " + this.especie);
        System.out.println("Edad: " + this.edad + " años");
    }

    public void cumplirAnios() {
        this.edad++;
        System.out.println(this.nombre + " cumplió años y ahora tiene " + this.edad + " años");
    }
}
