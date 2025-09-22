package Citas;

import java.util.Date;

public class CitaMedica {
    private Date fecha;
    private String hora;
    private Paciente paciente; // Unidireccional
    private Profesional profesional; // Unidireccional

    public CitaMedica(Date fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }
}
