package Documentos;

import java.util.Date;

public class FirmaDigital {
    private String codigoHash;
    private Date fecha;
    private Usuario usuario; // Agregación

    public FirmaDigital(String codigoHash, Date fecha, Usuario usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
}
