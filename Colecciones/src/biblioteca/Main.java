package biblioteca;

public class Main {

    public static void main(String[] args) {
        
    Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central UTN");

    Autor hemingway = new Autor("A001", "Ernest Hemingway", "Estadounidense");
    Autor bradbury = new Autor("A002", "Ray Bradbury", "Estadounidense");
    Autor poe = new Autor("A003", "Edgar Allan Poe", "Estadounidense");

    miBiblioteca.agregarLibro("978-0743273565", "El viejo y el mar", 1952, hemingway);
    miBiblioteca.agregarLibro("978-0345342966", "Fahrenheit 451", 1953, bradbury);
    miBiblioteca.agregarLibro("978-0451524935", "Crónicas marcianas", 1950, bradbury);
    miBiblioteca.agregarLibro("978-0140445667", "El Cuervo y otros poemas", 1845, poe);
    miBiblioteca.agregarLibro("978-1503289047", "Cuentos completos", 1849, poe);

    miBiblioteca.listarLibros();

    // Buscar un libro por ISBN
    Libro libroBuscado = miBiblioteca.buscarLibroPorIsbn("978-0743273565");
    if (libroBuscado != null) {
        System.out.println("\nLibro buscado por ISBN:");
        libroBuscado.mostrarInfo();
    }

    // Filtrar y mostrar libros de un año
    System.out.println("\nLibros publicados en 1953: ");
    miBiblioteca.filtrarLibrosPorAnio(1953).forEach(Libro::mostrarInfo);

    // Eliminar un libro y listar restantes
    System.out.println("\nEliminando libro 'El Cuervo'...");
    miBiblioteca.eliminarLibro("978-0140445667");
    miBiblioteca.listarLibros();

    System.out.println("\nCantidad total de libros: " + miBiblioteca.obtenerCantidadLibros());

    miBiblioteca.mostrarAutoresDisponibles();
    }
}