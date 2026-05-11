package ArquitecturaMulticapa.Empleados.Servicio;

import ArquitecturaMulticapa.Empleados.Dominio.Employee;

import java.util.List;

public interface IServicioEmpleado {
    void addEmployee(Employee employee);
    void showEmployee();
    List<Employee> getEmployee();
}
