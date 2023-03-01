package com.gen.educatech.controller;

import com.gen.educatech.model.Product;
import com.gen.educatech.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Product>> getByDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(productRepository.findByDescricaoContainingIgnoreCase(descricao));
    }

    @GetMapping("/valor/{valor}")
    public ResponseEntity<List<Product>> getByValor(@PathVariable float valor) {
        return ResponseEntity.ok(productRepository.findByValor(valor));

    }

    @GetMapping("/disponivel/{disponivel}")
    public ResponseEntity<List<Product>> getByDisponivel(@PathVariable boolean disponivel) {
        return ResponseEntity.ok(productRepository.findByDisponivel(disponivel));
    }

    @PostMapping
    public ResponseEntity<Product> post(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @PutMapping
    public ResponseEntity<Product> put(@Valid @RequestBody Product product) {
        return productRepository.findById(product.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        productRepository.deleteById(id);
    }
}
