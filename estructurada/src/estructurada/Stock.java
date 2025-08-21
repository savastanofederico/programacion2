package estructurada;

import java.util.Scanner;

public class Stock {
    
    // Método para actualizar el stock
    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresá el stock actual del producto: ");
        int stockActual = scanner.nextInt();
        System.out.print("Ingresá la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();
        System.out.print("Ingresá la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();
        
        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
    }
}