package stock;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad; // stock
    private CategoriaProducto categoria;

    // Constructor
    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() { return id; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }
    public double getPrecio() { return precio; }

    public void mostrarInfo() {
        System.out.printf("ID: %s | Nombre: %s | Precio: $%.2f | Stock: %d | Categoría: %s (%s)\n",
                id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion());
    }
}