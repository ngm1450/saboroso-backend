package com.nicolas.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nicolas.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(schema = "core", name = "credor_assinatura_adicional_plataforma")
public class IngredienteLanche extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lanche", referencedColumnName = "id", nullable = false)
    private Lanche lanche;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingrediente", referencedColumnName = "id", nullable = false)
    private Ingrediente ingrediente;

    public Lanche getLanche() { return lanche; }

    public void setLanche(Lanche lanche) { this.lanche = lanche; }

    public Ingrediente getIngrediente() { return ingrediente; }

    public void setIngrediente(Ingrediente ingrediente) { this.ingrediente = ingrediente; }
}
