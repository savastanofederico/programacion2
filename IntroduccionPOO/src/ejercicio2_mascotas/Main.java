/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2_mascotas;

/**
 *
 * @author federico
 */
public class Main {
    public static void main(String[] args) {
       
        Mascota miMascota = new Mascota("Iggie", "Iguana", 2);

        // Información inicial
        miMascota.mostrarInfo();

        // Simula el paso del tiempo
        miMascota.cumplirAnios();
        miMascota.cumplirAnios();

        // Modificación
        miMascota.mostrarInfo();
    }
}