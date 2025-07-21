package com.infosys.Product_Service.Service;

import com.infosys.Product_Service.Entity.Product;
import com.infosys.Product_Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository repo;

    public String notifyFromAccount (String username)
    {
        return "Product Service Notified For User: "+username;
    }

    public List<Product>getAllProducts()
    {
        return repo.findAll();
    }

    public List<Product> searchByPrefix(String prefix)
    {
        return repo.findByProductNameStartingWithIgnoreCase(prefix);
    }

    public Product addProduct(Product product) {
        System.out.println("Saving product with ID: " + product.getProductId());
        return repo.save(product);
    }

}
