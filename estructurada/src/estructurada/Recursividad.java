package estructurada;

public class Recursividad {

    public static void imprimirArrayRecursivo(double[] arr, int index) {
        // Si el índice es mayor o igual a la longitud del array, termina la recursión
        if (index >= arr.length) {
            return;
        }
        System.out.println("Precio: $" + arr[index]);
        // Avanza al siguiente elemento
        imprimirArrayRecursivo(arr, index + 1);
    }

    public static void main(String[] args) {
        // Declara e inicializa un array de precios
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        
        // Usa la función recursiva para mostrar los precios originales
        System.out.println("Precios originales:");
        imprimirArrayRecursivo(precios, 0);

        // Modifica el precio de un producto específico (índice 2)
        precios[2] = 110.19;

        // Usa la función recursiva para mostrar los valores modificados
        System.out.println("\nPrecios modificados:");
        imprimirArrayRecursivo(precios, 0);
    }
}