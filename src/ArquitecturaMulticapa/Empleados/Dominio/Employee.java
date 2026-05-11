package ArquitecturaMulticapa.Empleados.Dominio;

import java.io.Serializable;

public class Employee implements Serializable {
    private static int contadorEmployee = 0;
    private int idEmployee;
    private String nombre;
    private String apellido;
    private double salario;

    public Employee(){
        this.idEmployee = ++ Employee.contadorEmployee; //contador empleado y asigno id
    }

    public Employee(String nombre, String apellido, double salario){
        this();// llamo al constructor vacío para asignar id
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.salario    = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado { " +
                "id = " + idEmployee +
                ",\t nombre = " + nombre +
                ",\t apellido = " + apellido +
                ",\t salario = " + salario +
                " }";
    }

    public String writeEmployee(){
        return idEmployee +"," + nombre +","+ apellido + "," + salario;
    }
}
