package QR;

public class GeneradorQR {
    public void generar(String valor, Usuario usuario) {

        CodigoQR codigo = new CodigoQR(valor, usuario);
        System.out.println("Código QR generado para: " + usuario.getNombre() + " con el valor: " + codigo.getValor());
    }
}