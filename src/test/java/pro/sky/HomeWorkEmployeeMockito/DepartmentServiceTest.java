package pro.sky.HomeWorkEmployeeMockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HomeWorkEmployeeMockito.exception.EmployeeNotFoundException;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;
import pro.sky.HomeWorkEmployeeMockito.service.DepartmentService;
import pro.sky.HomeWorkEmployeeMockito.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {


    private final Employee MAX_SALARY = new Employee(
            "Piter",
            "usovich",
            1,
            23100);

    private final Employee MIN_SALARY = new Employee(
            "Garry",
            "White",
            2,
            400);

    private final List<Employee> EMPLOYEES = List.of(
            MAX_SALARY,
            MIN_SALARY
    );
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentService out;

    @BeforeEach
    void setUp() {
        when(employeeServiceMock.getEmployeesList()).thenReturn(EMPLOYEES);
        out = new DepartmentService(employeeServiceMock);
    }

//    @Test
//    void getAllByDepartment() {
//        List<Employee> expected = List.of(
//                new Employee("Piter", "usovich", 1, 20000),
//                new Employee("Garry", "White", 2, 40000),
//                new Employee("Bard", "Simpson", 3, 40000)
//        );
//        List<Employee> result = List.of(
//                new Employee("Piter", "usovich", 1, 20000),
//                new Employee("Garry", "White", 2, 40000),
//                new Employee("Bard", "Simpson", 3, 40000)
//        );
//
//        Assertions.assertEquals(expected.size(), result.size());
//        Assertions.assertEquals(expected.get(0), result.get(0));
//        Assertions.assertEquals(expected.get(1), result.get(1));
//        verify(employeeServiceMock, only()).getEmployeeMap();
//
//    }

    @Test
    void employeeNotFound(){
        assertThrows(EmployeeNotFoundException.class, () -> out.getSalarySum(3));
    }



//    @Test
//    void returnSumSalary() {
//        when(employeeServiceMock.findAll()).thenReturn(EMPLOYEES);
//    }




    @Test
    public void testCreateList() {
        List<Employee> expected = new ArrayList<>();
        when(employeeServiceMock.getEmployeesList())
                .thenReturn(expected);
        assertTrue(employeeServiceMock.getEmployeesList().isEmpty());
        verify(employeeServiceMock, atMost(2)).getEmployeesList();

    }


    @Test
    void returnMinSumSalary() {
    }

    @Test
    void returnMaxSumSalary() {
    }


}
