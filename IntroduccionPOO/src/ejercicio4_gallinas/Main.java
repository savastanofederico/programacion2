/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4_gallinas;

/**
 *
 * @author federico
 */
public class Main {
    public static void main(String[] args) {
        
        Gallina gallina1 = new Gallina(1);
        Gallina gallina2 = new Gallina(2);

        // Simula acciones de la gallina 1
        System.out.println("Acciones de Gallina 1");
        gallina1.ponerHuevo();
        gallina1.ponerHuevo();
        gallina1.envejecer();
        gallina1.mostrarEstado();

        // Simula acciones de la gallina 2
        System.out.println("\nAcciones de Gallina 2");
        gallina2.envejecer();
        gallina2.ponerHuevo();
        gallina2.ponerHuevo();
        gallina2.ponerHuevo();
        gallina2.mostrarEstado();
    }
}
