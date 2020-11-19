package ru.sergsubin.documens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergsubin.documens.entity.Employee;
import ru.sergsubin.documens.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController extends AbstractController<Employee, EmployeeService>{

    public EmployeeController(EmployeeService service) {
        super(service);
    }
}
