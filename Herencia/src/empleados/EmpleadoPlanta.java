package empleados;

public class EmpleadoPlanta extends Empleado {
    private static final double SUELDO_BASE = 500000.0;

    public EmpleadoPlanta(String nombre) {
        super(nombre);
    }
    
    @Override
    public double calcularSueldo() {
        return SUELDO_BASE;
    }
}