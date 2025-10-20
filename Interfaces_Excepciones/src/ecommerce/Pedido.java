package ecommerce;

import java.util.List;
import java.util.ArrayList;

public class Pedido implements Pagable {
    private final List<Producto> productos = new ArrayList<>();
    private final Cliente cliente;
    private String estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "Creado";
        this.cliente.notificar("Tu pedido fue creado"); // notificado sobre pedido creado
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        this.cliente.notificar("El estado de tu pedido cambió a: " + nuevoEstado);
    } // notificado sobre cambio de estado 

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.calcularTotal(); 
        }
        return total;
    }
}
