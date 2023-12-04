package pro.sky.HomeWorkEmployeeMockito.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeMockito.api.DepartmentInterface;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentInterface {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> findAllDepartmentAll(int departmentId) {
        final Map<Integer, List<Employee>> employees = employeeService
                .myList(employeeService.getEmployeeMap())
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return employees;
    }

    @Override
    public Employee findEmployeeMaxSalaryInDepartment(int departmentId) {
        return employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee findEmployeeMinSalaryInDepartment(int departmentId) {
        return employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> findAllDepartment(int departmentId) {
        List<Employee> departmentEmployees = employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
        if (departmentEmployees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else
            return departmentEmployees;
    }


    @Override
    public List<Employee> getAllByDepartment(int departmentId) {
        List<Employee> temp = employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
        return temp;
    }
}
