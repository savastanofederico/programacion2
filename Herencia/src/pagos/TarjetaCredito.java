package pagos;

public class TarjetaCredito implements Pagable {
    @Override
    public void pagar(double monto) {
        System.out.printf("Pago de $%.2f pagado con tarjeta de crédito.\n", monto);
    }
}