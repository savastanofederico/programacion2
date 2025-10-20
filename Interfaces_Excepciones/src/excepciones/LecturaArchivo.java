package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaArchivo {
    public static void main(String[] args) {
        String rutaArchivo = "/Users/federico/Desktop/readme.rtf";

        try {
            File archivo = new File(rutaArchivo);
            Scanner lectorArchivo = new Scanner(archivo);
            System.out.println("Contenido del archivo '" + rutaArchivo + "':");

            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                System.out.println(linea);
            }
            lectorArchivo.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error: el archivo no se encontró en la ruta indicada: " + rutaArchivo);
        }
    }
}