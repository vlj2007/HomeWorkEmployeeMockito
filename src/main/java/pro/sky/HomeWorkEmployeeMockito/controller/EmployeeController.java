package pro.sky.HomeWorkEmployeeMockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWorkEmployeeMockito.api.EmployeeInterface;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeInterface service;

    public EmployeeController(EmployeeInterface service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee employeeAdd(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName,
                                @RequestParam(required = true) int departmentId,
                                @RequestParam(required = true) double salary) {
        return service.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee employeeRemove(@RequestParam(required = true) String firstName,
                                   @RequestParam(required = true) String lastName,
                                   @RequestParam(required = true) int departmentId,
                                   @RequestParam(required = true) double salary) {
        return service.remove(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/find")
    public Employee employeeFind(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName,
                                 @RequestParam(required = true) int departmentId,
                                 @RequestParam(required = true) double salary) {
        return service.find(firstName, lastName, departmentId, salary);
    }

    @GetMapping
    public Map<String, Employee> findAll() {
        return service.findAll();
    }



}
