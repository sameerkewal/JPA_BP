package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Sale;

import java.util.stream.Stream;

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
