package QR;

public class CodigoQR {
    private String valor;
    private Usuario usuario; // Asociación unidireccional

    public CodigoQR(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
    
    // Método agregado para solucionar el error
    public String getValor() {
        return valor;
    }
}