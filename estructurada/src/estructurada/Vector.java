package estructurada;

public class Vector {

    public static void main(String[] args) {
        
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};

        // Precios originales
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // Modifica el precio de un producto específico
        precios[2] = 110.19;

        // Muestra los precios modificados
        System.out.println("\nPrecios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }
}