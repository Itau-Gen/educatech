package com.gen.educatech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "tb_categoria_produtos")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo tipo_produto é obrigatório!")
    @Size(min = 5, max = 200, message = "O atributo tipo_produto deve conter no mínimo 05 e no máximo 200 caracteres")
    @Column(name = "tipo_produto")
    private String tipoProduto;

    @NotBlank(message = "O atributo descricao_tipo_produto é obrigatório!")
    @Size(min = 5, max = 200, message = "O atributo descricao_tipo_produto deve conter no mínimo 05 e no máximo 200 caracteres")
    @Column(name = "descricao_tipo_produto")
    private String descricaoTipoProduto;

    @NotBlank(message = "O atributo fornecedor é obrigatório!")
    @Size(min = 5, max = 50, message = "O atributo fornecedor deve conter no mínimo 5 e no máximo 50 caracteres")
    @Column(name = "fornecedor")
    private String fornecedor;

    @OneToMany(mappedBy = "categoriaProduto", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoriaProduto")
    private List<Product> produto;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getDescricaoTipoProduto() {
        return descricaoTipoProduto;
    }

    public void setDescricaoTipoProduto(String descricaoTipoProduto) {
        this.descricaoTipoProduto = descricaoTipoProduto;
    }

    public String setFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Product> getProduto() {
        return produto;
    }

    public void setProduto(List<Product> produto) {
        this.produto = produto;
    }
}
