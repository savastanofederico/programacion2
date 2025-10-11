package empleados;

public class EmpleadoTemporal extends Empleado {
    private static final double SUELDO_DIARIO = 15000.0;
    private int diasTrabajados;

    public EmpleadoTemporal(String nombre, int diasTrabajados) {
        super(nombre);
        this.diasTrabajados = diasTrabajados;
    }
    
    @Override
    public double calcularSueldo() {
        return SUELDO_DIARIO * diasTrabajados;
    }
}
