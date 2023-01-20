package com.nicolas.base;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseController<T, ID> {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    default List<T> findAll() {
        return getService().findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    default T findById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    default T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    default T update(@RequestBody T entity) {
        return getService().update(entity);
    }

    BaseService<T, ID> getService();

}
