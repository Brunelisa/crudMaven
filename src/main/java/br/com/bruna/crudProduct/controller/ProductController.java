package br.com.bruna.crudProduct.controller;

import br.com.bruna.crudProduct.model.Product;
import br.com.bruna.crudProduct.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Person EndPoint V2", tags = {"Product", "Model", "Endpoint"})
@RestController
@RequestMapping("/products/v1")
public class ProductController {
    @Autowired
    private ProductService service;

    @ApiOperation(value = "Persist a Product" , response = Product.class)
    @PostMapping
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @ApiOperation(value = "Find the Product" , response = Product.class)
    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }

    @ApiOperation(value = "Find the Product by the id" , response = Product.class)
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @ApiOperation(value = "Update a Product" , response = Product.class)
    @PutMapping
    public Product update(@RequestBody Product product) throws Exception{
        return service.update(product);
    }

    @ApiOperation(value = "Delete the product" , response = Product.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
