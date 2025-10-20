package excepciones;

import java.util.Scanner;

public class ValidacionEdad {

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120 años");
        }
        System.out.println("La edad " + edad + " es válida");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca una edad para validar: ");

        try {
            int edadIngresada = scanner.nextInt();
            validarEdad(edadIngresada);
        } catch (EdadInvalidaException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error: debe ingresar un número entero");
        } finally {
            scanner.close();
        }
    }
}
