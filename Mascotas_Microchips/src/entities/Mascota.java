package entities;

import java.time.LocalDate;

public class Mascota {
    private Long id;
    private Boolean eliminado;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNacimiento;
    private String duenio;
    
    private Microchip microchip; //relación 1 a 1 unidireccional
    
    public Mascota(){ //constructor vacío
        
    }
    
    public Mascota (Long id, Boolean eliminado, String nombre, String especie,
                   String raza, LocalDate fechaNacimiento, String duenio, Microchip microchip){
        this.id = id;
        this.eliminado = eliminado;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.duenio = duenio;
        this.microchip = microchip;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public Microchip getMicrochip() {
        return microchip;
    }

    public void setMicrochip(Microchip microchip) {
        this.microchip = microchip;
    }
    
    @Override
    public String toString(){
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", duenio='" + duenio + '\'' +
                ", microchip=" + (microchip != null ? microchip.getCodigo() : "N/A") + // Muestra solo el código
                ", eliminado=" + eliminado +
                '}';
    }    
   
    
}
