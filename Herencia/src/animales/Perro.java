package animales;

public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }
    
    @Override 
    public void hacerSonido() {
        super.describirAnimal(); 
        System.out.println("dice: guau");
    }
}
