package universidad;
import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos; // Colección cursos

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }
    
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursos() { return cursos; }
    

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            c.setProfesor(this); 
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.remove(c)) {
            c.setProfesor(null); 
        }
    }

    // Métodos
    public void listarCursos() {
        System.out.println("Cursos dictados por " + nombre + ":");
        if (cursos.isEmpty()) {
            System.out.println("  (Ninguno)");
            return;
        }
        cursos.forEach(c -> System.out.println("  - " + c.getCodigo() + ": " + c.getNombre()));
    }

    public void mostrarInfo() {
        System.out.printf("Profesor ID: %s | Nombre: %s | Especialidad: %s | Cursos: %d\n", 
            id, nombre, especialidad, cursos.size());
    }
}