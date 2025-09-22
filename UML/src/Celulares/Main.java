package Celulares;

public class Main {
    public static void main(String[] args) {
        Bateria bateria = new Bateria("Li-ion", 5000);
        Usuario usuario = new Usuario("Federico Savastano", "35401556");
        Celular celular = new Celular("A2530", "Apple", "15", bateria);
        
        celular.setUsuario(usuario);
        usuario.setCelular(celular);

        System.out.println("Celular " + celular.getMarca() + " asignado a " + usuario.getNombre());
    }
}