package ArquitecturaMulticapa.Servicio;

import ArquitecturaMulticapa.Dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ServicioSnacksArchivos  implements  IServicioSnacks{
    private final String NAME_FILE = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();
    //constructor
    public ServicioSnacksArchivos(){
        //creo el fichero si no existe
        var fichero = new File(NAME_FILE);
        var existe = false;

        try{
            existe = fichero.exists();
            if(existe){
                this.snacks = getSnacksFile();// si existe el fichero, obtengo los datos
            } else {
                //lo creamos
                var newFile = new PrintWriter(new FileWriter(fichero));
                newFile.close(); //asi lo guardo en disco
                System.out.println("Se ha creado el fichero...");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
        if(!existe){
            loadSnackIniciales();
        }
    }

    private void loadSnackIniciales(){
        this.addSnack(new Snack("Patatas", 80.0));
        this.addSnack(new Snack("Refresco Naranja", 70.0));
        this.addSnack(new Snack("Refresco Limon", 72.0));
        this.addSnack(new Snack("Galletas Principe", 69.0));
        this.addSnack(new Snack("Filipinos", 58.0));
        this.addSnack(new Snack("Sandwich de pollo", 96.0));
    }

    private List<Snack> getSnacksFile(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineasSnack =  Files.readAllLines(Paths.get(NAME_FILE));
            for(String linea: lineasSnack){
                String[] lineaSnack = linea.split(",");
                var idSnack     = lineaSnack[0]; //id snack pero no utilizamos
                var nameSnack   = lineaSnack[1];
                var priceSnack  = Double.parseDouble(lineaSnack[2]);
                var newSnack = new Snack(nameSnack, priceSnack);
                snacks.add(newSnack); //agrego al snack leido de la lista
            }

        } catch (Exception e) {
            System.out.println("Error al leer fichero de snacks: " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }


    @Override
    public void addSnack(Snack snack) {
        //agrego nuevo snack en memoria
        this.snacks.add(snack);
        //Guardo el nuevo snack en el fichero
        this.addSnackFile(snack);
    }

    private void addSnackFile(Snack snack){
        boolean anexar = false;
        var fichero = new File(NAME_FILE);
        try{
            //reviso si el fichero tiene contenido
            anexar = fichero.exists();
            var salida = new PrintWriter(new FileWriter(fichero, anexar));
            salida.println(snack.writeSnack()); //se guarda la información en el fichero
            salida.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void showSnacks() {
        System.out.println("---- Inventario Snacks ----");
        //lista de snacks de archivo
        var inventarioSnacks = "";
        for(var snack: this.snacks){
           inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);

    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
