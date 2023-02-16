package com.gen.educatech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table (name = "tb_categoria_produtos")
public class Category {
    @Id
    @Column (name = "tipo_produto")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productType;
    @NotBlank(message = "O atributo descricao_tipo_produto é obrigatório!")
    @Size(min = 5, max = 200, message = "O atributo descricao_tipo_produto deve conter no mínimo 05 e no máximo 200 caracteres")
    @Column (name = "descricao_tipo_produto")
    private String productTypeDescribe;
    @NotBlank(message = "O atributo fornecedor é obrigatório!")
    @Size(min = 5, max = 50, message = "O atributo fornecedor deve conter no mínimo 5 e no máximo 50 caracteres")
    @Column (name = "fornecedor")
    private String partner;

    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getProductTypeDescribe() {
        return productTypeDescribe;
    }
    public void setProductTypeDescribe(String productTypeDescribe) {
        this.productTypeDescribe = productTypeDescribe;
    }
    public String getPartner() {
        return partner;
    }
    public void setPartner(String partner) {
        this.partner = partner;
    }
}
