package com.gen.educatech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_products")
public class  Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "É necessário descrever o produto!")
    @Size(min = 10, max = 40, message = "Digite entre 10 e 40 caracteres.")
    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "O valor não pode ser nulo")
    @Size(min = 1, max = 40, message = "Digite um valor entre 1 e 40 caracteres.")
    @Column(name = "valor")
    private float valor;

    @NotNull
    @Column(name = "disponivel")
    private boolean disponivel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
