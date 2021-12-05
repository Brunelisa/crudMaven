package br.com.bruna.crudProduct.controller;

import br.com.bruna.crudProduct.model.Product;
import br.com.bruna.crudProduct.services.ProductServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/v2")
public class ProductControllerV2 {
    @Autowired
    private ProductServiceV2 service;

    @PostMapping
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) throws Exception{
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/query/{name}")
    public List<Product> listByName(@PathVariable("name") String name){
        return service.listByName(name);
    }
}
