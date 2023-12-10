package org.example.service;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Sale;
import org.example.repositories.SaleRepository;

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
}
