package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.*;
import com.nicolas.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "core", name = "ingrediente_lanche")
@JsonIgnoreProperties(value = { "id" })
public class IngredienteLanche extends BaseEntity<Long>  implements Serializable {

    @Column(name = "qtd_ingrediente")
    private Integer qtdIngrediente;

//    @JsonIgnoreProperties("id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingrediente", referencedColumnName = "id", nullable = false)
    private Ingrediente ingrediente;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lanche", referencedColumnName = "id", nullable = false)
    private Lanche lanche;

    public Integer getQtdIngrediente() { return qtdIngrediente; }

    public void setQtdIngrediente(Integer qtdIngrediente) { this.qtdIngrediente = qtdIngrediente; }

    public Ingrediente getIngrediente() { return ingrediente; }

    public void setIngrediente(Ingrediente ingrediente) { this.ingrediente = ingrediente; }

    public Lanche getLanche() { return lanche; }

    public void setLanche(Lanche lanche) { this.lanche = lanche; }
}
