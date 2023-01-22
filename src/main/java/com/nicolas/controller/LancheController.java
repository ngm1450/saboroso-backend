package com.nicolas.controller;

import com.nicolas.base.BaseController;
import com.nicolas.base.BaseService;
import com.nicolas.model.entity.Lanche;
import com.nicolas.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lanches")
public class LancheController implements BaseController<Lanche, Long> {

    private final LancheService lancheService;

    @Autowired
    public LancheController(LancheService lancheService) {
        this.lancheService = lancheService;
    }

    @Override
    public BaseService<Lanche, Long> getService() {
        return lancheService;
    }

}
