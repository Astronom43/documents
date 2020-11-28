package ru.sergsubin.documens.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergsubin.documens.entity.Role;
import ru.sergsubin.documens.service.RoleService;

@Api(tags = "Контроллер по работе с ролями.")
@RestController
@RequestMapping("api/role")
public class RoleController extends AbstractController<Role, RoleService> {

    public RoleController(RoleService roleService) {
        super(roleService);
    }
}
