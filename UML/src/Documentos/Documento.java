package Documentos;

public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital; // Composición

    public Documento(String titulo, String contenido, FirmaDigital firmaDigital) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firmaDigital = firmaDigital;
    }
}
