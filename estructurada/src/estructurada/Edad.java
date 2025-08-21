package estructurada;

import java.util.Scanner;

public class Edad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresá tu edad: ");
        int edad = scanner.nextInt();

        if (edad < 12) {
            System.out.println("Sos un niño");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Sos un adolescente");
        } else if (edad >= 18 && edad <= 59) {
            System.out.println("Sos un adulto");
        } else {
            System.out.println("Sos un adulto mayor");
        }
    }
}

