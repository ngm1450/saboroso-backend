package com.nicolas.model.entity;

import java.util.List;

public class Lanche {

    private String nome;

    private Double preco;

    private List<Ingrediente> ingredientes;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
    
    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public List<Ingrediente> getIngredientes() { return ingredientes; }

    public void setIngredientes(List<Ingrediente> ingredientes) { this.ingredientes = ingredientes; }
}
