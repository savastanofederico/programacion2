package empleados;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 3: Empleados");
        
        List<Empleado> nomina = new ArrayList<>();
        nomina.add(new EmpleadoPlanta("Federico Savastano"));
        nomina.add(new EmpleadoTemporal("Maria Gonzalez", 20));
        nomina.add(new EmpleadoPlanta("Diego Butti"));
        nomina.add(new EmpleadoTemporal("Carolina Sosa", 15));

        for (Empleado emp : nomina) {
            double sueldo = emp.calcularSueldo(); 
            
            String tipo = "";
            
            // clasificación
            if (emp instanceof EmpleadoPlanta) {
                tipo = "Planta";
            } else if (emp instanceof EmpleadoTemporal) {
                tipo = "Temporal";
            } else {
                tipo = "Desconocido";
            }
            
            System.out.printf("Empleado: %s / Tipo: %s / Sueldo: $%.2f\n", emp.getNombre(), tipo, sueldo);
        }
    }
}
