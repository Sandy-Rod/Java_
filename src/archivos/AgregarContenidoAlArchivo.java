package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AgregarContenidoAlArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        var nombreFichero = "fichero.txt";
        var fichero = new File(nombreFichero);

        try{
            //reviso si el fichero tiene contenido
            anexar = fichero.exists();
            var salida = new PrintWriter(new FileWriter(fichero, anexar));

            var nuevoContenido = "\nLinea9\nLinea10\nLinea11";
            salida.println(nuevoContenido); //guardo el nuevo contenido en el fichero

            salida.close();
            System.out.println("Se agrego contenido al fichero...");

        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
