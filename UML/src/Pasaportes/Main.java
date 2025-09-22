package Pasaportes;

public class Main {
    public static void main(String[] args) {
        Titular titular = new Titular("Federico Savastano", "885500");
        Foto foto = new Foto("foto.jpg", "JPEG");
        Pasaporte pasaporte = new Pasaporte("AAD237033", "21-09-2025", foto, titular);
        System.out.println("Pasaporte creado para: " + pasaporte.getTitular().getNombre());
    }
}
