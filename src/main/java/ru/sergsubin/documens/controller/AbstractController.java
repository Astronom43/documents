package ru.sergsubin.documens.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sergsubin.documens.service.AbstractService;

import java.util.List;


public abstract class AbstractController<T, S extends AbstractService> {
    private final S s;

    protected AbstractController(S s) {
        this.s = s;
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll(){
        return s.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable(name = "id") Long id){
        return s.findById(id);
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T t){
        return s.save(t);
    }

    @PutMapping
    public ResponseEntity<T> put(@RequestBody T t){
        return s.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        s.delete(id);
    }

}
