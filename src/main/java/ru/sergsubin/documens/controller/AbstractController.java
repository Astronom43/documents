package ru.sergsubin.documens.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sergsubin.documens.entity.Views;
import ru.sergsubin.documens.service.AbstractService;

import java.util.List;


public abstract class AbstractController<T, S extends AbstractService<T,?>> {
    private final S s;

    protected AbstractController(S s) {
        this.s = s;
    }

    @GetMapping
    @JsonView(Views.IdBody.class)
    public ResponseEntity<List<T>> findAll(){
        return s.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.IdBodyRef.class)
    public ResponseEntity<T> findById(@PathVariable(name = "id") Long id){
        return s.findById(id);
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T t){
        return s.save(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> put(@PathVariable(name = "id") Long id,@RequestBody T t){
        return s.save(id,t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        s.delete(id);
    }

}
