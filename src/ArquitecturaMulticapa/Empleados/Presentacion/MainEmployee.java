package ArquitecturaMulticapa.Empleados.Presentacion;



import ArquitecturaMulticapa.Empleados.Dominio.Employee;
import ArquitecturaMulticapa.Empleados.Servicio.EmployeeServicio;
import ArquitecturaMulticapa.Empleados.Servicio.IServicioEmpleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEmployee {
    public static void main(String[] args) {
        controlEmployee();
    }
    public static void controlEmployee(){
        var salir = false;
        var consola = new Scanner(System.in);
        IServicioEmpleado servicioEmpleado = new EmployeeServicio();

        List<Employee> employeesList = new ArrayList<>();

        System.out.println(" **** Gestor de Empleados ***");

        servicioEmpleado.showEmployee();

        while(!salir){
            try {
                var opcion = showMenu(consola);
                salir = ejecutarOpciones(opcion, consola, employeesList, servicioEmpleado);
            } catch (Exception e) {
                System.out.println("Ocurrio un error a mostrar menu: " + e.getMessage());
            }
            finally {
                System.out.println("Gestor empleados... ");
            }
        }
    }

    private static int showMenu(Scanner consola){
        System.out.println("""
                Menu :
                1. Guardar nuevo empleados 3 
                2. Listado de empleados 4
                3. Salir
                Elige una opcion \s """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Employee> employeeList, IServicioEmpleado servicioEmpleado){
        var salir = false;
        switch (opcion){
            case 1 -> newEmployee(consola, servicioEmpleado);
            case 2 -> listarEmployees(consola, servicioEmpleado);

            case 3 -> {
                System.out.println("Hasta pronto ...");
                salir = true;
            }
            default -> System.out.println("Opcion no valida " + opcion);
        }
        return salir;
    }

    private static void listarEmployees(Scanner consola, IServicioEmpleado servicioEmpleado){
        servicioEmpleado.showEmployee();
    }

    private static void newEmployee(Scanner consola, IServicioEmpleado servicioEmpleado){
        System.out.println("Nombre empleado: \t");
        var nombreEmpleado = consola.nextLine();

        System.out.println("Apellido empleado; \t");
        var apellidoEmpleado = consola.nextLine();

        System.out.println("Salario empleado: \t");
        var salario = Double.parseDouble(consola.nextLine());

        servicioEmpleado.addEmployee(new Employee(nombreEmpleado, apellidoEmpleado, salario));

        System.out.println("Datos del nuevo empleado guardado correctamente...");
        servicioEmpleado.showEmployee();
    }























}