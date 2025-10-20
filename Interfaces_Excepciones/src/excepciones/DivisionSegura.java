package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduzca el dividendo: ");
            double dividendo = scanner.nextDouble();

            System.out.print("Introduzca el divisor: ");
            double divisor = scanner.nextDouble();

            if (divisor == 0) {
                throw new ArithmeticException("El divisor no puede ser cero");
            } // se lanza la excepción si es cero

            double resultado = dividendo / divisor;
            System.out.println("El resultado de la división es: " + resultado);

        } catch (InputMismatchException e) {
            System.err.println("Error: hay que introducir un número válido");
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("El programa finalizó");
        }
    }
}