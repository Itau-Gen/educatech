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

@RestController
@RequestMapping(value = {"/category"})
@CrossOrigin(value = "*", allowedHeaders = "*")

public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    @GetMapping("/tipo_produto/{tipoProduto}")
    public ResponseEntity<List<Category>> getByTipoProduto(@PathVariable String tipoProduto) {
        return ResponseEntity.ok(categoryRepository.findByTipoProdutoContainingIgnoreCase(tipoProduto));
    }

    @GetMapping("/descricao_tipo_produto/{descricaoTipoProduto}")
    public ResponseEntity<List<Category>> getByDescricaoTipoProduto(@PathVariable String descricaoTipoProduto) {
        return ResponseEntity.ok(categoryRepository.findByDescricaoTipoProdutoContainingIgnoreCase(descricaoTipoProduto));
    }

    @GetMapping("/fornecedor/{fornecedor}")
    public ResponseEntity<List<Category>> getByFornecedor(@PathVariable String fornecedor) {
        return ResponseEntity.ok(categoryRepository.findByFornecedorContainingIgnoreCase(fornecedor));
    }

    @PostMapping
    public ResponseEntity<Category> post(@Valid @RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));


    }

    @PutMapping
    public ResponseEntity<Category> put(@Valid @RequestBody Category category) {
        return categoryRepository.findById(category.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(category)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categoryRepository.deleteById(id);
    }
}
