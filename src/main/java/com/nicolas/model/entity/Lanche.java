package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nicolas.base.BaseEntity;
import com.nicolas.model.entity.serializers.LancheSerializer;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lanche", schema = "core")
//@JsonSerialize(using = LancheSerializer.class)
public class Lanche extends BaseEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

//    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lanche", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredienteLanche> ingredientes = new ArrayList<>();

    @Transient
    private Double preco;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public List<IngredienteLanche> getIngredientes() { return ingredientes; }

    public void setIngredientes(List<IngredienteLanche> ingredientes) { this.ingredientes = ingredientes; }
}
