package ecommerce;

public class PayPal implements Pago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal por un importe de $" + monto);
        return true;
    }
}