package com.gen.educatech.repository;

import com.gen.educatech.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public List<Category> findByProductTypeDescribeContaining(@Param("descricao_tipo_produto") String productTypeDescribe);
}
