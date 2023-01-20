package com.nicolas.base;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity<T extends Serializable> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}