package pagos;

public class Transferencia implements Pagable {
    @Override
    public void pagar(double monto) {
        System.out.printf("Pago de $%.2f pagado por transferencia bancaria.\n", monto);
    }
}