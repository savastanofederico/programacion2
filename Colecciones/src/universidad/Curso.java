package universidad;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }
    
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesor != nuevoProfesor) {
            
            // Sacar el curso del profesor anterior
            if (this.profesor != null) {
                this.profesor.getCursos().remove(this); 
            }

            // Asignar el nuevo profesor
            this.profesor = nuevoProfesor;

            // Agregar el curso al nuevo profesor
            if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
                nuevoProfesor.getCursos().add(this); 
            }
        }
    }

    public void mostrarInfo() {
        String nombreProfesor = (profesor != null) ? profesor.getNombre() : "SIN ASIGNAR";
        System.out.printf("Curso: %s (%s) | Profesor: %s\n", codigo, nombre, nombreProfesor); 
    }
}