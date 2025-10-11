package animales;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 4: Animales");
        
        List<Animal> granja = new ArrayList<>();
        granja.add(new Perro("Pancho"));
        granja.add(new Gato("Bartolo"));
        granja.add(new Vaca("Marta"));

        for (Animal animal : granja) {
            animal.hacerSonido(); 
        }
    }
}