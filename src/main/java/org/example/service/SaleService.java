package org.example.service;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Sale;
import org.example.entities.SaleProducts;
import org.example.repositories.SaleRepository;

import java.util.List;

public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService() {
        this.saleRepository = new SaleRepository(JPAConfiguration.getEntityManager());
    }

    public Sale add(Sale sale){
        return saleRepository.add(sale);
    }


    public void delete(Sale sale){
        saleRepository.delete(sale);
    }

    public Sale find(Integer id){
        return saleRepository.find(id, Sale.class);
    }

    public List<SaleProducts> getProductsFromSale(Sale sale){
         return saleRepository.getProductsFromSale(sale);
    }
}
