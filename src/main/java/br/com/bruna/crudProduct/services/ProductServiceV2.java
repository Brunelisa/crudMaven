package br.com.bruna.crudProduct.services;

import br.com.bruna.crudProduct.model.Product;
import br.com.bruna.crudProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceV2 {
    @Autowired
    private ProductRepository repository;

    public Product save(Product product){

        product.setRegisterDate(new Date());
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
        found.setShipment(product.getShipment());
        return repository.save(found);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) throws Exception{
        Product found = repository.findById(id).orElseThrow(() -> new Exception("Not found"));
        repository.delete(found);

    }

    @Autowired
    private EntityManager em;

    public List<Product> listByName(String name){
        String hql = "from Product where name like " + " :name order by name";
        Query query = em.createQuery(hql);
        query.setParameter("name", name + "%");
        List<Product> products = query.getResultList();
        return products;
    }
}
