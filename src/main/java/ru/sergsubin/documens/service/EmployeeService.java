package ru.sergsubin.documens.service;

import org.springframework.stereotype.Service;
import ru.sergsubin.documens.entity.Employee;
import ru.sergsubin.documens.repo.EmployeeRepo;

import java.util.Collection;

@Service
public class EmployeeService extends AbstractService<Employee, EmployeeRepo> {

    public EmployeeService(EmployeeRepo repo) {
        super(repo);
    }
}
