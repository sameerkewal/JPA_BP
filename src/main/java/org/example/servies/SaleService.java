package org.example.servies;

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
}
