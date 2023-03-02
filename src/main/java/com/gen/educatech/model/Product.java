package com.gen.educatech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Column(name = "valor")
    private float valor;

    @NotNull
    @Column(name = "disponivel")
    private boolean disponivel;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Category categoriaProduto;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Usuario usuario;



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

    public Category getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(Category categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
