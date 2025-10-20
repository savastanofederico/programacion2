package excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaConRecursos {
    public static void main(String[] args) {
        String rutaArchivo = "/Users/federico/Desktop/readme.rtf";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            System.out.println("Contenido del archivo:");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}