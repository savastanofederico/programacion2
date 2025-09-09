/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5_naves;

/**
 *
 * @author federico
 */
public class NaveEspacial {
  
    private String nombre;
    private double combustible;
    private final double MAX_COMBUSTIBLE = 100.0; // Límite de combustible

    
    public NaveEspacial(String nombre, double combustibleInicial) {
        this.nombre = nombre;
        this.combustible = combustibleInicial;
    }

    // Métodos
    public void despegar() {
        System.out.println(this.nombre + " despegó");
    }

    public void avanzar(double distancia) {
        double combustibleNecesario = distancia * 0.5; 
        if (this.combustible >= combustibleNecesario) {
            this.combustible -= combustibleNecesario;
            System.out.println(this.nombre + " avanza " + distancia + " km. Combustible restante: " + this.combustible);
        } else {
            System.out.println("Atención. No hay suficiente combustible para avanzar " + distancia + " km");
        }
    }

    public void recargarCombustible(double cantidad) {
        double nuevoCombustible = this.combustible + cantidad;
        if (nuevoCombustible <= MAX_COMBUSTIBLE) {
            this.combustible = nuevoCombustible;
            System.out.println(this.nombre + " recargó " + cantidad + " unidades. Total: " + this.combustible);
        } else {
            System.out.println("Atención. El tanque de combustible está a punto de explotar, cuidado! La nave no puede recargar esa cantidad. El límite es " + MAX_COMBUSTIBLE);
            this.combustible = MAX_COMBUSTIBLE; 
        }
    }

    public void mostrarEstado() {
        System.out.println("Estado de la nave " + this.nombre + " ");
        System.out.println("Combustible: " + this.combustible + " unidades");
    }
}