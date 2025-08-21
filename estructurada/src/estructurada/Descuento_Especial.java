package estructurada;

import java.util.Scanner;

public class Descuento_Especial {

    // Variable global
    public static final double DESCUENTO_GLOBAL = 0.10;

    // Método para calcular el descuento especial
    public static void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_GLOBAL;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresá el precio del producto: ");
        double precio = scanner.nextDouble();
        
        calcularDescuentoEspecial(precio);
    }
}