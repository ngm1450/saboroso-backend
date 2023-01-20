package com.nicolas.service;

import com.nicolas.base.BaseService;
import com.nicolas.model.entity.Lanche;
import com.nicolas.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LancheService implements BaseService<Lanche, Long> {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    @Override
    public JpaRepository<Lanche, Long> getRepository() { return lancheRepository; }
}
