package ArquitecturaMulticapa.Empleados.Servicio;

import ArquitecturaMulticapa.Empleados.Dominio.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServicio implements IServicioEmpleado{

    private final String NAME_FILE = "employee.txt";
    private List<Employee> employees = new ArrayList<>();

    //constructor
    public EmployeeServicio(){
        //si no existe, creo fichero
        var fichero = new File(NAME_FILE);
        var existe = false;
        try{
            existe = fichero.exists();
            if(existe){
                this.employees = getEmployeeFile(); // cargo datos desde fichero
            } else {
                var newFile = new PrintWriter(new FileWriter(fichero));
                newFile.close();
                System.out.println("Se ha creado el fichero...");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el fichero: " + e.getMessage() );
        }
        if(!existe){
            loadEmployeeIniciales();
        }
    }

    private void loadEmployeeIniciales(){
        this.addEmployee(new Employee("Paco", "Perez", 1234.97));
        this.addEmployee(new Employee("Pepe", "Perez", 1234.98));
        this.addEmployee(new Employee("Paca", "Perez", 1234.99));
    }

    private List<Employee> getEmployeeFile(){
        var employees = new ArrayList<Employee>();
        try{
            List<String> lineasEmpleado = Files.readAllLines(Paths.get(NAME_FILE));
            for(String linea: lineasEmpleado){
                String[] lineaEmpleado = linea.split(",");
                var nombreEmpleado = lineaEmpleado[1];
                var apellidoEmpleado = lineaEmpleado[2];
                var salarioEmpleado = Double.parseDouble(lineaEmpleado[3]);
                var newEmployee = new Employee(nombreEmpleado,apellidoEmpleado,salarioEmpleado);
                employees.add(newEmployee);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar empleados..." + e.getMessage());
        }
        return employees;
    }




    @Override
    public void addEmployee(Employee employee) {
        this.employees.add(employee); //nuevo en memoria
        this.addEmployeeFile(employee); //guardo en el fichero
    }

    private void addEmployeeFile(Employee employee){
        boolean anexar = false;
        var fichero = new File(NAME_FILE);
        try{
            anexar = fichero.exists();
            var salida = new PrintWriter(new FileWriter(fichero, anexar));
            salida.println(employee.writeEmployee()); // guardo linea con información de empleado
            salida.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al guardar empleado en fichero: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void showEmployee() {
        System.out.println("--- Inventario Empleados ---");
        var inventarioEmpleados = "";
        for(var empleado : this.employees){
            inventarioEmpleados += empleado.toString() + "\n";
        }
        System.out.println(inventarioEmpleados);
    }

    @Override
    public List<Employee> getEmployee() {
        return this.employees;
    }
}
