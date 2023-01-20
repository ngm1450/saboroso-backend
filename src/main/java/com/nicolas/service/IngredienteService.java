package com.nicolas.service;

import com.nicolas.model.entity.Ingrediente;
import com.nicolas.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
         this.ingredienteRepository = ingredienteRepository;
    }

    public JpaRepository<Ingrediente, Long> getRepository() {
        return ingredienteRepository;
    }
}
