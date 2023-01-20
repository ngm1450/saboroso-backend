package com.nicolas.controller;

import com.nicolas.base.BaseController;
import com.nicolas.base.BaseService;
import com.nicolas.model.entity.Ingrediente;
//import com.nicolas.service.IngredienteService;
import com.nicolas.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteController implements BaseController<Ingrediente, Long> {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Override
    public BaseService<Ingrediente, Long> getService() {
        return ingredienteService;
    }
}
