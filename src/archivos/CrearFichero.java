package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearFichero {
    public static void main(String[] args) throws IOException {
        var nombreFichero = "fichero.txt";
        var fichero = new File(nombreFichero);

        try {
            if (fichero.exists()) {
                System.out.println("El fichero ya existe");
            } else {
                //creo el fichero
                var salida = new PrintWriter(new FileWriter(fichero));
                salida.close();
                System.out.println("fichero creado");
            }
        } catch (IOException e){
            System.out.println("Error al crear fichero: " + e.getMessage());
            e.printStackTrace();
        }



    }




}
