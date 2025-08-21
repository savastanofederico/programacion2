package estructurada;

import java.util.Scanner;

public class Suma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int sumaPares = 0;

        System.out.println("Ingresá un número (0 para terminar):");
        
        while ((numero = scanner.nextInt()) != 0) {
            if (numero % 2 == 0) {
                sumaPares += numero;
            }
            System.out.println("Ingresá un número (0 para terminar):");
        }
        
        System.out.println("La suma de los números pares es: " + sumaPares);
    }
}