package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nicolas.base.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lanche extends BaseEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Double preco;

//    @JsonManagedReference
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lanche", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ingrediente> ingredientes;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }
//
//    public List<Ingrediente> getIngredientes() { return ingredientes; }
//
//    public void setIngredientes(List<Ingrediente> ingredientes) { this.ingredientes = ingredientes; }
}
