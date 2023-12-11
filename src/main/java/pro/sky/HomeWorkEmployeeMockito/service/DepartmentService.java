package pro.sky.HomeWorkEmployeeMockito.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWorkEmployeeMockito.api.DepartmentInterface;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class DepartmentService implements DepartmentInterface {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public int getSalarySum(int departmentId){
        return employeeService.getEmployeesList().stream()
                .filter(e -> e.getDepartment() ==departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
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
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeMinSalaryInDepartment(int departmentId) {
        return employeeService.getEmployeesList()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
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
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        final Map<Integer, List<Employee>> employees =
                employeeService.getEmployeesList()
                        .stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment()));

        return employees;

    }

}
