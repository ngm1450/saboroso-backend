package com.nicolas.controller;

import com.nicolas.model.entity.Ingrediente;
//import com.nicolas.service.IngredienteService;
import com.nicolas.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientes")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    public @ResponseBody List<Ingrediente> hello() {
        List<Ingrediente> dummyIngredientes = new ArrayList<>();
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome("Alface");
        ingrediente.setPreco(0.4);
        dummyIngredientes.add(ingrediente);
        return dummyIngredientes;
    }
}
