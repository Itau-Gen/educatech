package com.gen.educatech.repository;



import com.gen.educatech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByDescricaoContainingIgnoreCase (@Param("descricao") String descricao);

    public List<Product> findByValor(@Param("valor") float valor);

    public List<Product> findByDisponivel (@Param("disponivel") boolean disponivel);
    public Optional<Product> findById(Long id);

}

