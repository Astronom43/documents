package ru.sergsubin.documens.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sergsubin.documens.entity.Role;

@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role, Long> {

}
