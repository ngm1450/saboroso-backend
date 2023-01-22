package com.nicolas.service;

import com.nicolas.model.entity.Lanche;

public interface MetodosPromocao {

    void setValorPromocao(Lanche lanche);

    void setLight(Lanche lanche);

    void setMuitaCarne(Lanche lanche);

    void setMuitoQueijo(Lanche lanche);
}
