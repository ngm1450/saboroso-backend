package com.nicolas.repository;

import com.nicolas.model.entity.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {

    @Query("select distinct l from Lanche l left join fetch l.ingredientes as ig left join fetch ig.ingrediente")
    List<Lanche> findAllWithIngredientes();

    @Query("select distinct l from Lanche l left join fetch l.ingredientes as ig left join fetch ig.ingrediente i where l.id = ?1")
    Lanche findByIdWithIngredientes(Long id);
}
