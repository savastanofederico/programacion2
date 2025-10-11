package animales;

public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }
    
    @Override 
    public void hacerSonido() {
        super.describirAnimal();
        System.out.println("dice: miau");
    }
}
