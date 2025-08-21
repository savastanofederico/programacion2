package estructurada;

import java.util.Scanner;

public class Compra {

    // Para calcular el costo de envío
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5; // $5 por kg
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10; // $10 por kg
        } else {
            return 0;
        }
    }

    // Para calcular el total de la compra
    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresá el precio del producto: ");
        double precioProducto = scanner.nextDouble();
        System.out.print("Ingresá el peso del paquete en kg: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingresá la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double totalPagar = calcularTotalCompra(precioProducto, costoEnvio);
        
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + totalPagar);
    }
}