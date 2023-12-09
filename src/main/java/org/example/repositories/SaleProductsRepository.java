package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.SaleProducts;

public class SaleProductsRepository extends Repository<SaleProducts>{
    public SaleProductsRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SaleProducts update(SaleProducts object) {
        return null;
    }
}
