package com.nicolas.repository;

import com.nicolas.model.entity.Ingrediente;
import com.nicolas.model.entity.IngredienteLanche;
import com.nicolas.model.entity.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteLancheRepository extends JpaRepository<IngredienteLanche, Long> {

    List<IngredienteLanche> findAllByLanche(Lanche lanche);
}
