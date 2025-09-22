package Libros;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("Federico Savastano", "Argentino");
        Editorial editorial = new Editorial("Planeta", "Av. Santa Fe 3000");

        Libro libro = new Libro("UML básico", "978-0-8899-432", autor, editorial);

        System.out.println("Libro creado:");
        System.out.println("  Título: " + libro.getTitulo());
        System.out.println("  ISBN: " + libro.getIsbn());
        System.out.println("  Autor: " + libro.getAutor().getNombre());
        System.out.println("  Editorial: " + libro.getEditorial().getNombre());
    }
}