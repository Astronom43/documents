package ru.sergsubin.documens.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import ru.sergsubin.documens.entity.Role;
import ru.sergsubin.documens.repo.RoleRepo;

@Service
public class RoleService extends AbstractService<Role, RoleRepo> {

    protected RoleService(RoleRepo repo) {
        super(repo);
    }
}
