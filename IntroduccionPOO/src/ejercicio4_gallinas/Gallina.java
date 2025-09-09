/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4_gallinas;

/**
 *
 * @author federico
 */
public class Gallina {
   
    private int idGallina;
    private int edad;
    private int huevosPuestos;
    private static int contadorGallinas = 0; // Para asignar un ID único a cada gallina

   
    public Gallina(int edad) {
        this.idGallina = ++contadorGallinas;
        this.edad = edad;
        this.huevosPuestos = 0;
    }

    // Métodos
    public void ponerHuevo() {
        this.huevosPuestos++;
        System.out.println("Gallina " + this.idGallina + " puso un huevo. Total: " + this.huevosPuestos);
    }

    public void envejecer() {
        this.edad++;
        System.out.println("Gallina " + this.idGallina + " envejeció. Ahora tiene " + this.edad + " años");
    }

    public void mostrarEstado() {
        System.out.println("Estado de la Gallina " + this.idGallina + " ");
        System.out.println("Edad: " + this.edad + " años");
        System.out.println("Huevos puestos: " + this.huevosPuestos);
    }
}
