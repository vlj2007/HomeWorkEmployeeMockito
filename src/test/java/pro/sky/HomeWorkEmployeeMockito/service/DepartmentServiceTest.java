package pro.sky.HomeWorkEmployeeMockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void getSalarySum() {
        int resultSum = departmentService.getSalarySum(1);
        assertEquals(0, resultSum);
    }

    @Test
    void getSalarySum2() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        int resultSum = departmentService.getSalarySum(1);
        assertEquals(20000, resultSum);
    }

    @Test
    void findEmployeeMaxSalaryInDepartment() {
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeMaxSalaryInDepartment(3));
    }

    @Test
    void findEmployeeMinSalaryInDepartment0() {
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeMinSalaryInDepartment(3));
    }


    @Test
    void testFindEmployeeMaxSalaryInDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        int resultFindEmployeeMaxSalaryInDepartment = departmentService.findEmployeeMaxSalaryInDepartment(2).getSalary();
        assertEquals(60000, resultFindEmployeeMaxSalaryInDepartment);
    }

    @Test
    void findEmployeeMinSalaryInDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 2, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        int resultFindEmployeeMinSalaryInDepartment = departmentService.findEmployeeMinSalaryInDepartment(2).getSalary();
        assertEquals(20000, resultFindEmployeeMinSalaryInDepartment);
    }

    @Test
    void findAllDepartmentAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        int resultDepartmentAll = departmentService.findAllDepartmentAll(2).size();
        assertTrue(departmentService.findAllDepartmentAll().containsValue(employees));
    }

    @Test
    void findAllDepartmentAll3() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        boolean resultDepartmentAll = departmentService.findAllDepartmentAll(2).containsValue(2);
        assertTrue(departmentService.findAllDepartmentAll().containsValue(employees));
    }

    @Test
    public void shouldReturnEmployeeListByDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        employees.add(new Employee("Piter", "usovich", 3, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        List<Employee> result = departmentService.findAllDepartment(3);
        assertTrue(employees.containsAll(result));
    }

    @Test
    public void shouldReturnEmployeeListByDepartment2() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        employees.add(new Employee("Piter", "usovich", 3, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(employees);
        Map<Integer, List<Employee>> result = departmentService.findAllDepartmentAll();
        assertTrue(employees.containsAll(Collections.singleton(result)));
    }

    @Test
    public void shouldReturnExceptionWhenCallMinSalaryMethodAndEmptyEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Piter", "usovich", 1, 20000));
        employees.add(new Employee("Piter", "usovich", 2, 60000));
        employees.add(new Employee("Piter", "usovich", 3, 60000));
        Mockito.when(employeeServiceMock.getEmployeesList()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeMinSalaryInDepartment(1));
    }


}