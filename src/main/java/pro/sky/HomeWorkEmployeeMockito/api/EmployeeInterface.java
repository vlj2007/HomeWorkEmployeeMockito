package pro.sky.HomeWorkEmployeeMockito.api;

import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeInterface {

    Employee add(String firstName, String lastName, int department, double salary);

    Employee remove(String firstName, String lastName, int department, double salary);

    Employee find(String firstName, String lastName, int department, double salary);

    Map<String, Employee> findAll();

    Map<String, Employee> getEmployeeMap();

    public List<Employee> getEmployeesList();

    List<Employee> myList(Map<String, Employee> employeeMap);
}
