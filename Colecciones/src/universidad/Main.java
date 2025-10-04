package universidad;

public class Main {

    public static void main(String[] args) {

        Universidad utn = new Universidad("UTN-FRBA");

        Profesor ariel = new Profesor("P001", "Ariel Enferrel", "POO");
        Profesor cinthia = new Profesor("P002", "Cinthia Rigoni", "Sistemas");
        Profesor marcos = new Profesor("P003", "Marcos Vega", "Matemáticas");

        Curso prog1 = new Curso("C101", "Programación 1");
        Curso prog2 = new Curso("C102", "Programación 2");
        Curso ayso = new Curso("C201", "AySO");
        Curso bd1 = new Curso("C301", "Base de datos 1");
        Curso probEst = new Curso("C401", "Probabilidad y Estadística");

        utn.agregarProfesor(ariel);
        utn.agregarProfesor(cinthia);
        utn.agregarProfesor(marcos);
        utn.agregarCurso(prog1);
        utn.agregarCurso(prog2);
        utn.agregarCurso(ayso);
        utn.agregarCurso(bd1);
        utn.agregarCurso(probEst);
        System.out.println("Profesores y cursos cargados");

        System.out.println("\nAsignación inicial");
        utn.asignarProfesorACurso("C101", "P001"); 
        utn.asignarProfesorACurso("C102", "P001"); 
        utn.asignarProfesorACurso("C201", "P002"); 
        utn.asignarProfesorACurso("C301", "P003"); 

        utn.listarCursos();
        utn.listarProfesores();
        ariel.listarCursos();

        // Cambiar el profesor de un curso 
        System.out.println("\nCambio de profesor (Prog2: Ariel -> Cinthia)");
        utn.asignarProfesorACurso("C102", "P002"); 
        utn.listarCursos(); 
        ariel.listarCursos();
        cinthia.listarCursos(); 

        // Remover un curso
        System.out.println("\nEliminación de curso (BD1)");
        utn.eliminarCurso("C301");
        utn.listarCursos();
        marcos.listarCursos(); 

        // Remover un profesor
        System.out.println("\nEliminación de profesor (Marcos)");
        utn.eliminarProfesor("P003"); 
        utn.listarProfesores();
        utn.listarCursos(); 

        utn.mostrarReporteCursosPorProfesor();
    } 
}