package org.example.servies;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Product;
import org.example.repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;


    public ProductService() {
        this.productRepository = new ProductRepository(JPAConfiguration.getEntityManager());
    }


    public Product add(Product product){
        return productRepository.add(product);
    }

    public Product update(Product product){
        return productRepository.update(product);
    }

    public Product find(Integer id){
        return productRepository.find(id, Product.class);
    }


    public List<Product> findProductByManufacturer(String manufacturer){
        return productRepository.findProductByManufacturer(manufacturer);
    }

    public List<Product>getProductByName(String productName){
        return productRepository.getProductByName(productName);
    }
}
