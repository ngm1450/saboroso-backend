package com.nicolas.model.entity;

import com.nicolas.base.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Ingrediente extends BaseEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Double preco;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
}
