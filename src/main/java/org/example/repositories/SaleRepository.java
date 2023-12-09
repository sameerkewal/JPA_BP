package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Sale;

public class SaleRepository extends Repository<Sale> {

    private EntityManager entityManager;

    public SaleRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Sale update(Sale object) {
        return null;
    }


}
