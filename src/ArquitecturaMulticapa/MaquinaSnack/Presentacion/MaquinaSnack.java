package ArquitecturaMulticapa.MaquinaSnack.Presentacion;

import ArquitecturaMulticapa.MaquinaSnack.Dominio.Snack;
import ArquitecturaMulticapa.MaquinaSnack.Servicio.IServicioSnacks;
import ArquitecturaMulticapa.MaquinaSnack.Servicio.ServicioSnacksArchivos;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaSnack {
    public static void main(String[] args) {

        maquinaSnacks();
    }


    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creo el objeto para obtener el servicio de snacks desde fichero
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();

        //Creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();

        System.out.println("*** Maquina de ServicioSnacksArchivo ***");

        servicioSnacks.showSnacks(); //Mostrar inventario de snacks disponibles

        while(!salir){
            try{
                var opcion = showMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);

            }catch (Exception e){
                System.out.println(" Ocurrio un error: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }

    private static int showMenu(Scanner consola){
        System.out.println("""
                Menu:
                1. Comprar Snack
                2. Mostrar ticket
                3. Agregar nuevo Snack
                4. Inventario Snacks
                5. Salir
                Elige un opcion: \s """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos, servicioSnacks);
            case 2 -> showTicket(productos);
            case 3 -> addSnack(consola, servicioSnacks);
            case 4 -> listarInventarioSnack(consola, servicioSnacks);

            case 5 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion invalida " + opcion);
        }

        return salir;

    }

    private static  void listarInventarioSnack(Scanner consola, IServicioSnacks servicioSnacks){
        servicioSnacks.showSnacks();

    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        System.out.println("Que snack quieres comprar (id) ?");
        var idSnack = Integer.parseInt(consola.nextLine());
        var snackEncontrado = false;
        for(var snack: servicioSnacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                //agrego el snack a la lista de productos
                productos.add(snack);
                System.out.println("ok, snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if(!snackEncontrado){ //si no encuentro el id del snack
            System.out.println("Id de snack no encontrado: " + idSnack);
        }
    }

    private static void showTicket(List<Snack> productos){
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for (var producto : productos){
            ticket += "\n \t * " + producto.getNombre() + " - " + producto.getPrecio() + " €";
            total += producto.getPrecio();
        }

        ticket += "\n \n \t \t \t \t \t Total -> " + total + " €";
        System.out.println(ticket);


    }

    private static void addSnack(Scanner consola, IServicioSnacks servicioSnacks){
        System.out.print("Nombre del snack: \t");
        var nombreSnack = consola.nextLine();

        System.out.print("precio del snack: \t");
        var precioSnack = Double.parseDouble(consola.nextLine());

        servicioSnacks.addSnack(new Snack(nombreSnack, precioSnack));

        System.out.println("tu snack se ha agregado correctamente");
        servicioSnacks.showSnacks();

    }
}