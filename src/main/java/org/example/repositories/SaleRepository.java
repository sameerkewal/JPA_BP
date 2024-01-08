package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Sale;
import org.example.entities.SaleProducts;

import java.util.List;

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

    public List<SaleProducts> getProductsFromSale(Sale sale){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select sps from SaleProducts sps where sps.sale.id=:p1");
        query.setParameter("p1", sale.getId());
        List<SaleProducts> resultList = query.getResultList();
        this.entityManager.getTransaction().commit();

        return resultList;
    }


}
