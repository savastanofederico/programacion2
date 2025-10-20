package ecommerce;

public class MainEcommerce {

    public static void main(String[] args) {
        Cliente clienteFederico = new Cliente("Federico");

        // productos
        Producto sarten = new Producto("Sartén de teflón", 15000.00);
        Producto olla = new Producto("Olla a presión", 20000.00);
        Producto espatula = new Producto("Espátula de silicona", 1200.00);

        // pedido y productos
        Pedido miPedido = new Pedido(clienteFederico);
        miPedido.agregarProducto(sarten);
        miPedido.agregarProducto(olla);
        miPedido.agregarProducto(espatula);

        double totalPedido = miPedido.calcularTotal(); // total del pedido
        System.out.println("El total del pedido es: $" + String.format("%.2f", totalPedido));

        miPedido.setEstado("En preparación"); // cambia estado del pedido

        System.out.println("\nIntentando pagar...");
        TarjetaCredito visa = new TarjetaCredito();
        PayPal payPal = new PayPal();

        visa.procesarPago(totalPedido); //pago tarjeta con descuento

        payPal.procesarPago(totalPedido); //pago tarjeta sin descuento

        miPedido.setEstado("Enviado");
    }
}
