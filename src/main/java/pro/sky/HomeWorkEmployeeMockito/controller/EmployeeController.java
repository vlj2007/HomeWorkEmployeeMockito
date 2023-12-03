package pro.sky.HomeWorkEmployeeMockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeMockito.api.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.Collection;

@RestController
public class EmployeeController {

    private final EmployeeInterface service;

    public EmployeeController(EmployeeInterface service) {
        this.service = service;

    }

    @GetMapping(path = "/employee/add")
    public Employee employeeAdd(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping(path = "/employee/remove")
    public Employee employeeRemove(@RequestParam(required = true) String firstName,
                                   @RequestParam(required = true) String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping(path = "/employee/find")
    public Employee employeeFind(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/department/{id}/employees")
    public Employee departmentIdEmployees(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/department/{id}/salary/sum")
    public Employee departmentSalarySum(@RequestParam(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "department/{id}/salary/max")
    public Employee departmentSalaryMax(@RequestParam(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/department/{id}/salary/min")
    public Employee departmentSalaryMin(@RequestParam(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }

    @GetMapping(path = "/department/employees")
    public Employee departmentEmployees(@RequestParam(required = true) String firstName,
                                        @RequestParam(required = true) String lastName) {
        return null;
    }



}
