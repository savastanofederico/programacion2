public class Main {
    
    public static void main(String[] args) {
        
        // Empleado 1 (usando los 2 constructores)
        Empleado emp1 = new Empleado(1, "Federico Savastano", "Recepcionista", 1300000);
        
        // Empleado 2 (usando solo nombre y puesto)
        Empleado emp2 = new Empleado("Ana Lopez", "Desarrolladora");
        
        // Empleado 3 (usando solo nombre y puesto)
        Empleado emp3 = new Empleado("Carlos Ruiz", "Gerente");

        // salida con toString
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());

        // Sobrecarga actualizarSalario
        System.out.println("\n--- Actualizando salarios ---");
        // Aumento del empleado 1
        emp1.actualizarSalario(50000);
        System.out.println("Salario de " + emp1.getNombre() + " actualizado: " + emp1.getSalario());

        // Aumentar del empleado 2 porcentaje
        emp2.actualizarSalario(10);
        System.out.println("Salario de " + emp2.getNombre() + " actualizado: " + emp2.getSalario());

        // Total empleados
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}