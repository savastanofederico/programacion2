package biblioteca;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public String getNombre() { return nombre; }
    
    public void mostrarInfo() {
        System.out.printf("Autor ID: %s | Nombre: %s | Nacionalidad: %s\n", id, nombre, nacionalidad);
    } 
}
