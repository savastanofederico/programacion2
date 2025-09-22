package Cuentas;

import java.util.Date;

public class ClaveSeguridad {
    private String codigo;
    private Date ultimaModificacion;

    public ClaveSeguridad(String codigo) {
        this.codigo = codigo;
        this.ultimaModificacion = new Date();
    }
}