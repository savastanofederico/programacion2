package Pasaportes;

public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto; // Composición
    private Titular titular; // Asociación bidireccional

    public Pasaporte(String numero, String fechaEmision, Foto foto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
        this.titular = titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Titular getTitular() {
        return titular;
    }
}