package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nicolas.base.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lanche", schema = "core")
public class Lanche extends BaseEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lanche", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredienteLanche> ingredientes;

    @Transient
    private Double preco;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public List<IngredienteLanche> getIngredientes() { return ingredientes; }

    public void setIngredientes(List<IngredienteLanche> ingredientes) { this.ingredientes = ingredientes; }
}
