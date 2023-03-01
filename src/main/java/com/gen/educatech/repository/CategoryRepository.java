package com.gen.educatech.repository;

import com.gen.educatech.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    public List<Category> findByTipoProdutoContainingIgnoreCase (@Param("tipo_produto") String tipoProduto);

    public List<Category> findByDescricaoTipoProdutoContainingIgnoreCase (@Param("descricao_tipo_produto") String descricaoTipoProduto);

    public List<Category> findByFornecedorContainingIgnoreCase (@Param("fornecedor") String fornecedor);
    public Optional<Category> findById(Long id);
}
