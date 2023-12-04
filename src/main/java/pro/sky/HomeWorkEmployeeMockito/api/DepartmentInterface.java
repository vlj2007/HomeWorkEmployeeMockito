package pro.sky.HomeWorkEmployeeMockito.api;

import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentInterface {

    List<Employee> getAllByDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllDepartmentAll(int departmentId);

    Employee findEmployeeMaxSalaryInDepartment(int departmentId);

    Employee findEmployeeMinSalaryInDepartment(int departmentId);

    List<Employee> findAllDepartment(int departmentId);

}
