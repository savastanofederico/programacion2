package estructurada;

import java.util.Scanner;

public class Descuento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresá el precio del producto: ");
        double precioOriginal = scanner.nextDouble();
        System.out.print("Ingresá la categoría del producto (A, B o C): ");
        char categoria = scanner.next().toUpperCase().charAt(0);

        double descuento = 0;
        String porcentajeDescuento = "";

        if (categoria == 'A') {
            descuento = precioOriginal * 0.10;
            porcentajeDescuento = "10%";
        } else if (categoria == 'B') {
            descuento = precioOriginal * 0.15;
            porcentajeDescuento = "15%";
        } else if (categoria == 'C') {
            descuento = precioOriginal * 0.20;
            porcentajeDescuento = "20%";
        }

        double precioFinal = precioOriginal - descuento;

        System.out.println("Descuento aplicado: " + porcentajeDescuento);
        System.out.println("Precio final: " + precioFinal);
    }
}