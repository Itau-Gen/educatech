package com.gen.educatech.controller;

import com.gen.educatech.model.Category;
import com.gen.educatech.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.hibernate.Hibernate.map;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable String id) {
        return categoryRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/{productTypeDescribe}")
    public ResponseEntity<List<Category>> getByproductTypeDescribe(@PathVariable String productTypeDescribe) {
        return ResponseEntity.ok(categoryRepository.findByProductTypeDescribeContaining(productTypeDescribe));
    }
    @PostMapping
    public ResponseEntity<Category> post (@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));
    }
    @PutMapping
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
        return categoryRepository.findById(category.getProductType())
                .map(response -> ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(categoryRepository.save(category)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categoryRepository.deleteById(id);
    }
}
