package ru.sergsubin.documens.service;

import org.springframework.beans.BeanUtils;
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
        if (all.iterator().hasNext()) return new ResponseEntity<>((List<T>) all, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<T> findById(Long id) {
        Optional<T> byId = repo.findById(id);
        return byId.map(t -> new ResponseEntity<>(t, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<T> save(T t) {
        return new ResponseEntity<>(repo.save(t), HttpStatus.OK);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public ResponseEntity<T> save(Long id, T t) {
        Optional<T> byIdFromDb = repo.findById(id);

        if (byIdFromDb.isPresent()) {
           T t1 = byIdFromDb.get();
            BeanUtils.copyProperties(t, t1, "id");
            return new ResponseEntity<>(repo.save(t1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
