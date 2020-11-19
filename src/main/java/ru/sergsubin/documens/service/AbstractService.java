package ru.sergsubin.documens.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, R extends PagingAndSortingRepository<T, Long>> {
    private final R repo;

    protected AbstractService(R repo) {
        this.repo = repo;
    }


    public ResponseEntity<List<T>> findAll() {
        Iterable<T> all = repo.findAll();
        if (all != null) return new ResponseEntity<List<T>>((List<T>) all, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<T> findById(Long id) {
        Optional<T> byId = repo.findById(id);
        if (byId.isPresent()) return new ResponseEntity<T>(byId.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<T> save(T t) {
        return new ResponseEntity<>(repo.save(t),HttpStatus.OK);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
