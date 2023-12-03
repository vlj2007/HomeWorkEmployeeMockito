package pro.sky.HomeWorkEmployeeMockito.api;

import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.Collection;

public interface EmployeeInterface {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}
