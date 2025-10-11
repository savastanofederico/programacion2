package figuras;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 2: Figuras");
        
        // array de superclase
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(5.0)); 
        figuras.add(new Rectangulo(4.0, 6.0)); 
        figuras.add(new Circulo(2.5));
        
        for (Figura figura : figuras) {
            double area = figura.calcularArea(); 
            System.out.printf("Area de la figura %s: %.2f", figura.getNombre(), area);
        }
    }
}
