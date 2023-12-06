package pro.sky.HomeWorkEmployeeMockito.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeMockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;


    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(path = "/{Id}/employees")
    public Map<Integer, List<Employee>> departmentIdEmployees(@PathVariable("departmentId") int departmentId) {
        return service.findAllDepartmentAll(departmentId);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public int departmentSalarySum(@PathVariable("departmentId") int departmentId) {
        return service.getSalarySum(departmentId);
//        return service.
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee departmentSalaryMax(@PathVariable("departmentId") int departmentId) {
        return service.findEmployeeMaxSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee departmentSalaryMin(@PathVariable("departmentId") int departmentId) {
        return service.findEmployeeMinSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> departmentEmployees(@PathVariable("departmentId") int departmentId) {
        return (Map<Integer, List<Employee>>) service.getAllByDepartment(departmentId);
    }

}
