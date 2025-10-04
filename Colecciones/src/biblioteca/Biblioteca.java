package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private final List<Libro> libros; // Colección libros

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }
    
    // Métodos 
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro); 
    }
    
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null; 
    }

    public void listarLibros() {
        System.out.println("\nLibros en la biblioteca: " + nombre + " ");
        for (Libro libro : libros) {
            libro.mostrarInfo(); 
        }
    }

    public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn);
        if (libroAEliminar != null) {
            return libros.remove(libroAEliminar); 
        }
        return false;
    }

    public int obtenerCantidadLibros() {
        return libros.size(); 
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> filtrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                filtrados.add(libro);
            }
        }
        return filtrados; 
    }

    public void mostrarAutoresDisponibles() {
        System.out.println("\nAutores Disponibles");
        List<String> nombresAutores = new ArrayList<>();
        for (Libro libro : libros) {
            String nombreAutor = libro.getAutor().getNombre();
            if (!nombresAutores.contains(nombreAutor)) {
                nombresAutores.add(nombreAutor);
            }
        }
        nombresAutores.forEach(System.out::println);
    }
}