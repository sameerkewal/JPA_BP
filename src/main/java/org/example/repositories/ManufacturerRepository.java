package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import org.example.entities.Manufacturer;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ManufacturerRepository extends Repository<Manufacturer>{

    private EntityManager entityManager;
    public ManufacturerRepository(EntityManager entityManager) {

        super(entityManager);
        this.entityManager = entityManager;
    }



    @Override
    public Manufacturer update(Manufacturer manufacturer) {

        try {
            entityManager.getTransaction().begin();
            Manufacturer manufacturerToUpdate = find(manufacturer.getId(), Manufacturer.class);

            manufacturerToUpdate.setName(manufacturer.getName());
            manufacturerToUpdate.setCountry(manufacturer.getCountry());

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        return find(manufacturer.getId(), Manufacturer.class);


    }


    public Manufacturer findManufacturerByName(String name) {
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select mfr from Manufacturer mfr where " +
                "lower(name)=lower(:p1)");

        query.setParameter("p1", name);

        List<Manufacturer> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
