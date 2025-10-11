package pagos;

public class Efectivo implements Pagable {
    @Override
    public void pagar(double monto) {
        System.out.printf("Pago de $%.2f pagado en efectivo\n", monto);
    }
}
