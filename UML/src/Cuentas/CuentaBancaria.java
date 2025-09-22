package Cuentas;

public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad claveSeguridad; // Composición
    private Titular titular; // Bidireccional

    public CuentaBancaria(String cbu, double saldo, String codigoClave) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.claveSeguridad = new ClaveSeguridad(codigoClave);
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }
}
