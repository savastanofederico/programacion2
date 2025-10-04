package stock;

public class Main {

    public static void main(String[] args) {

        // Tareas
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("ID001", "Galletitas", 550.0, 50, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("ID002", "Verduras (Mix)", 1250.0, 100, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("ID003", "Celular", 250000.0, 15, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("ID004", "Camisa", 2500.0, 30, CategoriaProducto.ROPA));
        inventario.agregarProducto(new Producto("ID005", "Mesa de centro", 15000.0, 5, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("ID006", "Teclado Mecánico", 2500.0, 25, CategoriaProducto.ELECTRONICA));
        System.out.println("Productos iniciales cargados.");

        inventario.listarProductos();

        // Buscar un producto por ID
        Producto buscado = inventario.buscarProductoPorId("ID004");
        if (buscado != null) {
            System.out.println("\nProducto buscado (ID004):");
            buscado.mostrarInfo();
        }

        // Filtrar y mostrar productos
        System.out.println("\nProductos en ELECTRONICA");
       
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA).forEach(Producto::mostrarInfo);

        // Eliminar un producto
        System.out.println("\nEliminando ID001...");
        inventario.eliminarProducto("ID001");
        inventario.listarProductos();

        // Actualizar el stock de un producto
        if (inventario.actualizarStock("ID003", 20)) {
            System.out.println("\nStock de ID003 actualizado a 20.");
            inventario.buscarProductoPorId("ID003").mostrarInfo();
        }
        
        // Stock
        System.out.println("\nTotal de stock en el inventario: " + inventario.obtenerTotalStock());

        // Mostrar el producto con mayor stock
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("\nProducto con mayor stock:");
            mayorStock.mostrarInfo();
        }

        // Filtrar productos con precios entre 1000 y 3000
        System.out.println("\nProductos entre $1000 y $3000");
        inventario.filtrarProductosPorPrecio(1000.0, 3000.0).forEach(Producto::mostrarInfo);

        inventario.mostrarCategoriasDisponibles();
    }
}
