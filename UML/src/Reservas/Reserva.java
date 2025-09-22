package Reservas;

import java.util.Date;

public class Reserva {
    private Date fecha;
    private String hora;
    private Cliente cliente; // Asociación unidireccional
    private Mesa mesa; // Agregación

    public Reserva(Date fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}
