package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.entities.Adress;
import org.example.entities.Manufacturer;

public class ManufacturerRepositoryCopy extends Repository<Manufacturer>{
    public ManufacturerRepositoryCopy(EntityManager entityManager) {

        super(entityManager);
    }

    @Override
    public Manufacturer add(Manufacturer object) {
        return super.add(object);
    }


    @Override
    public Manufacturer find(Integer id, Class<Manufacturer> entityclass) {
        return super.find(id, entityclass);
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        Manufacturer manufacturerToUpdate = find(manufacturer.getId(), Manufacturer.class);


        ;
    }
}
