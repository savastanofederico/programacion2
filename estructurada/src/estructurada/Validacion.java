package estructurada;

import java.util.Scanner;

public class Validacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nota;

        do {
            System.out.print("Ingresá una nota (0-10): ");
            nota = scanner.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingresá una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        
        System.out.println("Nota guardada correctamente.");
    }
}