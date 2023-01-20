package com.nicolas.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T, ID> {

    @Transactional(propagation = Propagation.SUPPORTS)
    default List<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    default T findById(ID id) {
        return getRepository().findById(id).orElseThrow();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    default T save(T entity) { return getRepository().save(entity); }

    @Transactional(propagation = Propagation.REQUIRED)
    default T update(T entity) { return getRepository().save(entity); }

    default JpaRepository<T, ID> getRepository() {
        throw new UnsupportedOperationException();
    }

}
