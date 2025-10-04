package universidad;
import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private final List<Profesor> profesores;
    private final List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Métodos 
    public void agregarProfesor(Profesor p) { profesores.add(p); } 
    public void agregarCurso(Curso c) { cursos.add(c); } 

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);
        
        if (curso != null && profesor != null) {
            curso.setProfesor(profesor); 
            System.out.printf("Asignación exitosa: %s a %s.\n", profesor.getNombre(), curso.getNombre());
        } else {
            System.out.println("Error: Profesor o curso no encontrados");
        }
    }

    public void listarProfesores() { 
        System.out.println("\nProfesores de la " + nombre + " ");
        profesores.forEach(Profesor::mostrarInfo);
    } 

    public void listarCursos() {
        System.out.println("\nCursos de la " + nombre + " ");
        cursos.forEach(Curso::mostrarInfo);
    } 

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.setProfesor(null); 
            }
            return cursos.remove(curso);
        }
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
          
            for (Curso c : new ArrayList<>(profesor.getCursos())) {
                c.setProfesor(null);
            }
            return profesores.remove(profesor);
        }
        return false;
    }

    // Reporte
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\nREPORTE: Cantidad de cursos por profesor");
        profesores.forEach(p -> System.out.printf("- %s: %d cursos\n", p.getNombre(), p.getCursos().size()));
    }
}