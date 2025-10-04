package stock;

import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Producto> productos; // Colección principal 

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Métodos
    public void agregarProducto(Producto p) {
        productos.add(p); 
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) { 
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    } 

    public void listarProductos() {
        System.out.println("LISTA COMPLETA DE PRODUCTOS");
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío");
            return;
        }
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    } 

    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            return productos.remove(p); 
        }
        return false;
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad); 
            return true;
        }
        return false;
    }

    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                filtrados.add(p);
            }
        }
        return filtrados; 
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total; 
    } 

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) return null;
        Producto mayorStock = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock; 
    }

    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max) {
        ArrayList<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                filtrados.add(p);
            }
        }
        return filtrados; 
    } 

    public void mostrarCategoriasDisponibles() {
        System.out.println("CATEGORÍAS DISPONIBLES");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.printf("- %s: %s\n", cat.name(), cat.getDescripcion());
        }
    }
}