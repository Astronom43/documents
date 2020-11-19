package ru.sergsubin.documens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergsubin.documens.entity.Role;
import ru.sergsubin.documens.repo.RoleRepo;

import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    RoleRepo repo;

    @GetMapping
    public ResponseEntity<List<Role>> gatAll(){
        Iterable<Role> all = repo.findAll();
        if (all!=null){
            return new ResponseEntity<List<Role>>((List<Role>) all, HttpStatus.OK);
           }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
