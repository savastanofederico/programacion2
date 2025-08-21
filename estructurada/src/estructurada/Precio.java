package estructurada;

import java.util.Scanner;

public class Precio {
    
    // Método para calcular el precio final
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresá el precio base del producto: ");
        double precioBase = scanner.nextDouble();
        System.out.print("Ingresá el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuesto = scanner.nextDouble() / 100;
        System.out.print("Ingresá el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuento = scanner.nextDouble() / 100;
        
        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);
        
        System.out.println("El precio final del producto es: " + precioFinal);
    }
}