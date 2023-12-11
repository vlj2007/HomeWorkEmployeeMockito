package pro.sky.HomeWorkEmployeeMockito;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.HomeWorkEmployeeMockito.exception.BadParamsException;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeStorageIsFullException;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;
import pro.sky.HomeWorkEmployeeMockito.service.EmployeeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {

    private EmployeeService out;
    private final Employee FIRST_EMPLOYEE = new Employee("Piter", "usovich", 1, 20000);
    private final Employee SECOND_EMPLOYEE = new Employee("Smith", "Wester", 1, 20000);

    @BeforeEach
    void serUp(){
        out = new EmployeeService();
    }

    @Test
    void shouldAddCorrectlyEmployee(){
        Employee add = out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartment(),
                FIRST_EMPLOYEE.getSalary()
        );
        assertEquals(FIRST_EMPLOYEE, add);
        assertEquals(1, out.getEmployeesList().size());
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedException(){
        out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartment(),
                FIRST_EMPLOYEE.getSalary()
        );
        assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> out.add(
                        FIRST_EMPLOYEE.getFirstName(),
                        FIRST_EMPLOYEE.getLastName(),
                        FIRST_EMPLOYEE.getDepartment(),
                        FIRST_EMPLOYEE.getSalary()
                )
        );
    }

//    @Test
//    void shouldEmployeeStorageIsFullException() {
//        out.add("Chaplis", "Oil", 1, 40000);
//        out.add("Matty", "littler", 1, 40000);
//        out.add("Garry", "White", 1, 40000);
//        out.add("Djime", "li", 1, 40000);
//        out.add("Dayver", "Uoolies", 1, 40000);
//        out.add("Charly", "Watter", 1, 40000);
//        out.add("billy", "Fuel", 1, 40000);
//        out.add("Wensdy", "Yelly", 1, 40000);
//        out.add("Anna", "Gigler", 1, 40000);
//        out.add("Bard", "Simpson", 1, 40000);
//        out.add("Jhone", "layer", 1, 40000);
//        out.add("April", "Holder", 1, 40000);
//        out.add("Joody", "Biskuy", 1, 40000);
//        out.add("Boris", "Donoton", 1, 40000);
//        out.add("Ostin", "Golder", 1, 40000);
//
//        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> out.add("Tom", "Soer",7, 89054));
//    }

//    @Test
//    void shouldAddAndRemoveCorrectly(){
//        out.add("Ostin", "Golder", 1, 40000);
//        assertEquals(1, out.findAll().size());
//        out.remove("Ostin", "Golder",1,40000);
//        assertEquals(0, out.findAll().size());
//    }

    @Test
    void shouldFindCorrectly(){
        out.add("Ostin", "Golder", 1, 40000);
        Employee expected = new Employee("Ostin", "Golder", 1, 40000);
        Employee result = out.find("Ostin", "Golder", 1, 40000);
        assertEquals(expected, result);
    }

//    @Test
//    void myList(){
//        out.add("Boris", "Donoton", 1, 40000);
//        out.add("Ostin", "Golder", 1, 40000);
//        List<Employee> expected = List.of(new Employee("Ostin", "Golder", 1, 40000),
//                out.add("Boris", "Donoton", 1, 40000));
//        List<Employee> result = out.myList("BorisDonoton", "Boris", "Donoton", 1, 40000);
//        assertEquals(expected.size(), result.size());
//        assertIterableEquals(expected, result);
//
//    }

    @Test
    void shouldThrowEmployeeNotFoundException(){
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.remove("Boris", "Donoton",1, 40000));
    }

//    @Test
//    void shouldThrowEmployeeBadParamsException(){
//        Assertions.assertThrows(BadParamsException.class, () -> out.remove("Boris", "Donoton",1, 40000));
//    }


}
