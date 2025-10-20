package ecommerce;

public class TarjetaCredito implements PagoConDescuento {
    private static final double PORCENTAJE_DESCUENTO = 0.10;

    @Override
    public double aplicarDescuento(double monto) {
        return monto * (1 - PORCENTAJE_DESCUENTO);
    }

    @Override
    public boolean procesarPago(double monto) {
        double montoFinal = aplicarDescuento(monto);
        System.out.println("Procesando pago con tarjeta de crédito con un importe de $" + montoFinal + " (Descuento aplicado)");
        return true;
    }
}