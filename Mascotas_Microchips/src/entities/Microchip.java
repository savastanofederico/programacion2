package entities;

import java.time.LocalDate;

public class Microchip {
    private Long id;
    private Boolean eliminado;
    private String codigo;
    private String observaciones;
    private String veterinaria;
    private LocalDate fechaImplantacion;
    
    public Microchip(){ //constructor vacío
    }
    
    public Microchip(Long id, Boolean elimiado, String codigo,
           LocalDate fechaImplantacion, String veterinaria, String observaciones)
    {
        this.id = id;
        this.eliminado = eliminado;
        this.codigo = codigo;
        this.observaciones = observaciones;
        this.veterinaria = veterinaria;
        this.fechaImplantacion = fechaImplantacion;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(String veterinaria) {
        this.veterinaria = veterinaria;
    }

    public LocalDate getFechaImplantacion() {
        return fechaImplantacion;
    }

    public void setFechaImplantacion(LocalDate fechaImplantacion) {
        this.fechaImplantacion = fechaImplantacion;
    }
    
    @Override
    public String toString(){
        return "Microchip{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", fechaImplantacion=" + fechaImplantacion +
                ", veterinaria='" + veterinaria + '\'' +
                ", eliminado=" + eliminado +
                '}';
    }
}
