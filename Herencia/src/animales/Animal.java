package animales;

public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido genérico");
    }
    
    public void describirAnimal() {
        System.out.print(nombre + " es un tipo de animal que ");
    }
}