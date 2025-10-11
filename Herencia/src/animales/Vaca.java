package animales;

public class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre);
    }
    
    @Override 
    public void hacerSonido() {
        super.describirAnimal();
        System.out.println("dice: muu");
    }
}