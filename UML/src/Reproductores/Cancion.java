package Reproductores;

public class Cancion {
    private String titulo;
    private Artista artista; // Unidireccional

    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }
}