package br.com.bruna.crudProduct.services;

import br.com.bruna.crudProduct.model.Product;
import br.com.bruna.crudProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

    public Product findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Not Found!"));
    }

    public Product update(Product product) throws Exception{
        Product found = repository.findById(product.getId()).orElseThrow(() -> new Exception("Not found!"));
        found.setName(product.getName());
        found.setCategory(product.getCategory());
        found.setPrice(product.getPrice());
        return repository.save(found);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) throws Exception{
        Product found = repository.findById(id).orElseThrow(() -> new Exception("Not found"));
        repository.delete(found);
    }
}
