package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/// Leo todo el contenido del fichero y luego imprimo linea a linea

public class LecturaFicheroV2 {
    public static void main(String[] args) {
        var nombreFichero = "fichero.txt";

        try{
            //leo todas las lineas del fichero

            List<String> lineas = Files.readAllLines(Paths.get(nombreFichero));
            System.out.println("Contenido del fichero");

            lineas.forEach(System.out::println); //imprimo linea a linea

        } catch (Exception e) {
            System.out.println("Error al leer fichero: " + e.getMessage());
        }
    }
}
