package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nicolas.base.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "ingrediente", schema = "core")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
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
