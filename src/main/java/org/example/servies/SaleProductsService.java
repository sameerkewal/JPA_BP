package org.example.servies;

import org.example.configuration.JPAConfiguration;
import org.example.entities.SaleProducts;
import org.example.repositories.SaleProductsRepository;

public class SaleProductsService {

    private final SaleProductsRepository saleProductsRepository;

    public SaleProductsService() {
        this.saleProductsRepository = new SaleProductsRepository(JPAConfiguration.getEntityManager());
    }

    public SaleProducts add(SaleProducts saleProducts){
        return saleProductsRepository.add(saleProducts);
    }
}
