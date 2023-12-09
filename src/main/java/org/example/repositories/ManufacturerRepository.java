package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Manufacturer;

import java.util.List;

public class ManufacturerRepository extends Repository<Manufacturer>{

    private EntityManager entityManager;
    public ManufacturerRepository(EntityManager entityManager) {

        super(entityManager);
        this.entityManager = entityManager;
    }



    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer manufacturerToUpdate = find(manufacturer.getId(), Manufacturer.class);
        entityManager.getTransaction().begin();


        manufacturerToUpdate.setName(manufacturer.getName());
        manufacturerToUpdate.setCountry(manufacturer.getCountry());


        entityManager.getTransaction().commit();

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
