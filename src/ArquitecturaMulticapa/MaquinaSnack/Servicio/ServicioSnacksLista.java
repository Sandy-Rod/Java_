package ArquitecturaMulticapa.MaquinaSnack.Servicio;

import ArquitecturaMulticapa.MaquinaSnack.Dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;


    //Bloque para inicializar atributos estaticos
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Patatas", 80.0));
        snacks.add(new Snack("Refresco Naranja", 70.0));
        snacks.add(new Snack("Refresco Limon", 72.0));
        snacks.add(new Snack("Galletas Principe", 69.0));
        snacks.add(new Snack("Filipinos", 58.0));
        snacks.add(new Snack("Sandwich de pollo", 96.0));
    }


    public void addSnack(Snack snack){
        snacks.add(snack);
    }

    public void showSnacks(){
        var inventarioSnacks = "";
        for(var snack: snacks){
            inventarioSnacks += snack.toString() + " \n";
        }

        System.out.println("--- Inventario de ServicioSnacksLista ---");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks(){
        return snacks;
    }
}
