package ArquitecturaMulticapa.MaquinaSnack.Dominio;


import java.io.Serializable;

public class Snack  implements Serializable {
    private static int contadorSnack = 0;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack(){
        this.idSnack = ++ Snack.contadorSnack;
    }

    public Snack(String nombre, double precio){
        this(); // llamo al constructor vacio, debe ser la primera linea
        this.nombre = nombre;
        this.precio = precio;

    }

    public int getIdSnack() {
        return idSnack;
    }

    public void setIdSnack(int idSnack) {
        this.idSnack = idSnack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack { " +
                "id = " + idSnack +
                ",\t nombre = " + nombre +
                ",\t precio = " + precio +
                " }";
    }

    public String writeSnack(){
        return idSnack + "," + nombre + ","+ precio;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

