package Celulares;

public class Usuario {
    private String nombre;
    private String dni;
    private Celular celular; // Bidireccional

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }
}