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

    @GetMapping(path = "/{departmentId}/employees")
    public Map<Integer, List<Employee>> departmentIdEmployees(@PathVariable("departmentId") int departmentId) {
        return service.findAllDepartmentAll(departmentId);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Employee departmentSalarySum(@PathVariable(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee departmentSalaryMax(@PathVariable(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee departmentSalaryMin(@PathVariable(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/employees")
    public Employee departmentEmployees(@RequestParam(required = true) String lastName) {
        return null;
    }

}
