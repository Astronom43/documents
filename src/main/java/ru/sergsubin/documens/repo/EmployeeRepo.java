package ru.sergsubin.documens.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sergsubin.documens.entity.Employee;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
}
