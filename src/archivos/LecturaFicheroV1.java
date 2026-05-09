package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaFicheroV1 {
    public static void main(String[] args) {
        //Leer fichero
        var nombreFichero = "fichero.txt";
        var fichero = new File(nombreFichero);

        try {
            System.out.println("Contenido del fichero: \n");

            //abro el fichero para lectura
            var entrada = new BufferedReader(new FileReader(fichero));

            //leo el fichero linea a linea
            var linea = entrada.readLine();

            while(linea != null){
                System.out.println(linea);
                linea = entrada.readLine(); //antes de salir del while leo la siguiente linea.
            }

            //Cierro el fichero
            entrada.close();

        } catch (Exception e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }
    }
}
