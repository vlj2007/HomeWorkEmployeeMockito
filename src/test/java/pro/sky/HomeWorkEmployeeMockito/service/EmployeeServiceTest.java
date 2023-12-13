package pro.sky.HomeWorkEmployeeMockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HomeWorkEmployeeMockito.api.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeIllegalNameOrLastNameException;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private final EmployeeInterface employeeInterface = new EmployeeService();

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of("Влад", "Волков", 1, 1000),
                Arguments.of("Артем", "Верблюдов", 2, 9000));
    }

    @Test
    void myList() {
        assertNotNull(employeeInterface.getEmployeesList());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void testAdd(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employeeInterface.add(firstName, lastName, department, salary);
        Assertions.assertEquals(employeeInterface.find(firstName, lastName, department, salary), employee);

    }

//    @Test
//    public void testAddWillThrowExceptionWhenIllegalName() {
//        Assertions.assertThrows(EmployeeIllegalNameOrLastNameException.class,
//                () -> {
//                    employeeInterface.add("!", "Верблюдов", 2, 9000);
//                });
//    }
//
//    @Test
//    public void testAddWillThrowExceptionWhenIllegalName2() {
//        Assertions.assertThrows(EmployeeIllegalNameOrLastNameException.class,
//                () -> {
//                    employeeInterface.add("!", "Верблюдов", 2, 9000);
//                });
//    }

//    @ParameterizedTest
//    @MethodSource("provideParamsForTest")
//    public void testAddWillThrowExceptionWhenIllegalName3(String firstName, String lastName, int department, int salary) {
//        Employee employee = new Employee(firstName, lastName, department, salary);
//        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
//                () -> {
//                    employeeInterface.add("Артем", "Верблюдов", 2, 9000);
//                });
//    }


    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void verificationAlreadyAddedException(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employeeInterface.add(employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    @Test
    public void testRemoveWillThrowExceptionWhenIllegalName() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> {
                    employeeInterface.remove("Артем", "Верблюдов", 2, 9000);
                });

    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void testRemoveWillThrowExceptionWhenIllegalName2(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> {
                    employeeInterface.remove("Dkflbv", "hdjhjfk", 2, 9000);
                });

    }

//    @ParameterizedTest
//    @MethodSource("provideParamsForTest")
//    void addCorrectlyEmployees(String firstName, String lastName, int department, int salary) {
//        Employee employee = new Employee(firstName, lastName, department, salary);
//        employeeInterface.add(employee.getFirstName(),
//                employee.getLastName(),
//                employee.getDepartment(),
//                employee.getSalary()
//        );
//        assertEquals(employee, employeeInterface.add(firstName, lastName, department, salary));
//        assertEquals(1, employeeInterface.findAll().size());
//    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void testFindOnContains() {
        assertNotNull(employeeInterface.findAll());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void testFindOnContains2(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> {
                    employeeInterface.remove("Владимир", "Носков", 2, 9000);
                });
    }

}