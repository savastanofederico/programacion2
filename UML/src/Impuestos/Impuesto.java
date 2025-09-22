package Impuestos;

public class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // Unidireccional

    public Impuesto(double monto, Contribuyente contribuyente) {
        this.monto = monto;
        this.contribuyente = contribuyente;
    }

    public double getMonto() {
        return monto;
    }
}
