/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5_naves;

/**
 *
 * @author federico
 */
public class Main {
    public static void main(String[] args) {
        
        NaveEspacial marte1 = new NaveEspacial("Marte1", 50.0);

        // Estado inicial
        marte1.mostrarEstado();

        // Intenta avanzar sin recargar
        System.out.println("\nIntentando avanzar sin recargar");
        marte1.avanzar(120);

        // Recarga combustible
        System.out.println("\nRecargando combustible");
        marte1.recargarCombustible(40);

        // Intenta recargar por encima del límite
        marte1.recargarCombustible(30);

        // Avanza con el combustible recargado
        System.out.println("\nVolviendo a avanzar");
        marte1.avanzar(120);

        // Estado final
        System.out.println("\nEstado final de la nave");
        marte1.mostrarEstado();
    }
}
