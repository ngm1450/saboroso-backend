package com.nicolas.service;

import com.nicolas.base.BaseService;
import com.nicolas.model.entity.Lanche;
import com.nicolas.repository.IngredienteLancheRepository;
import com.nicolas.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LancheService implements BaseService<Lanche, Long> {

    private final LancheRepository lancheRepository;
    private final CalculoPromocaoService calculoPromocaoService;
    private final IngredienteLancheRepository ingredienteLancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository,
                         CalculoPromocaoService calculoPromocaoService,
                         IngredienteLancheRepository ingredienteLancheRepository) {
        this.lancheRepository = lancheRepository;
        this.calculoPromocaoService = calculoPromocaoService;
        this.ingredienteLancheRepository = ingredienteLancheRepository;
    }

    @Override
    public List<Lanche> findAll() {
        List<Lanche> lanches = lancheRepository.findAllWithIngredientes();
        lanches.forEach(calculoPromocaoService::setValorPromocao);
        return lanches;
    }

    @Override
    public Lanche findById(Long id) {
        Lanche lanche = lancheRepository.findByIdWithIngredientes(id);
        if (Objects.nonNull(lanche)) calculoPromocaoService.setValorPromocao(lanche);
        return lanche;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Lanche save(Lanche lanche) {
        lanche.getIngredientes().forEach((i) -> i.setLanche(lanche));
        ingredienteLancheRepository.saveAll(lanche.getIngredientes());
        return lancheRepository.save(lanche);
    }

    private void setIngredientesLanches(List<Lanche> lanches) {
        lanches.forEach((l) -> l.setIngredientes(ingredienteLancheRepository.findAllByLanche(l)));
    }


    @Override
    public JpaRepository<Lanche, Long> getRepository() { return lancheRepository; }
}
