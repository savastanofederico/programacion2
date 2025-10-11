package pagos;

public class Main {
    
    public static void procesarPago(Pagable medio, double monto) {
        System.out.print("Procesando pago... ");
        medio.pagar(monto); 
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio 5: Pagos");
        
        Pagable tarjeta = new TarjetaCredito();
        Pagable transferencia = new Transferencia();
        Pagable efectivo = new Efectivo();
        
        procesarPago(tarjeta, 35400.15);
        procesarPago(transferencia, 105789.45);
        procesarPago(efectivo, 3000.00);
    }
}
