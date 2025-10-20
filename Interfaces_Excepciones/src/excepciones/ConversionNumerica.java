package excepciones;

import java.util.Scanner;

public class ConversionNumerica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca un texto para convertir a número entero: ");
        String texto = scanner.nextLine();

        try {
            int numero = Integer.parseInt(texto);
            System.out.println("El número convertido es: " + numero);
        } catch (NumberFormatException e) {
            System.err.println("Error: El texto '" + texto + "' no puede ser convertido a un número entero");
        } finally {
            scanner.close();
        }
    }
}
