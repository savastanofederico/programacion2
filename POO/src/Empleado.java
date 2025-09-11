public class Empleado {

    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    
    // Contador de empleados estático
    private static int totalEmpleados = 0;
    
    // C: todos los atributos
    public Empleado(int id, String nombre, String puesto, double salario) {
        // Uso de 'this' para asignar los parámetros a los atributos de la instancia
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        // Incrementa el contador global de empleados
        totalEmpleados++;
    }

    // C: solo nombre y puesto
    public Empleado(String nombre, String puesto) {
        // Asigna un ID automático (por ejemplo, el valor actual del contador)
        this.id = ++totalEmpleados; 
        this.nombre = nombre;
        this.puesto = puesto;
        // Asigna un salario por defecto
        this.salario = 500000; 
    }
    
    // Sobrecarga
    // Aumento porcentaje
    public void actualizarSalario(double porcentajeAumento) {
        this.salario = this.salario * (1 + porcentajeAumento / 100);
    }

    // Aumento cantidad fija
    public void actualizarSalario(int cantidadFija) {
        this.salario += cantidadFija;
    }

    // total de empleados estático
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
    
    // toString
    @Override
    public String toString() {
        return "Empleado [ID: " + this.id + ", Nombre: " + this.nombre + ", Puesto: " + this.puesto + ", Salario: " + this.salario + "]";
    }
    
    // getters y setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
