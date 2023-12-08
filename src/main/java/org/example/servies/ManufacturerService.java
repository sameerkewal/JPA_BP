package org.example.servies;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Manufacturer;
import org.example.repositories.ManufacturerRepository;

import java.util.List;

public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService() {
        this.manufacturerRepository = new ManufacturerRepository(JPAConfiguration.getEntityManager());


    }
    public Manufacturer addManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.add(manufacturer);
    }

    public Manufacturer find(Integer id){
        return manufacturerRepository.find(id, Manufacturer.class);
    }

    public Manufacturer update(Manufacturer manufacturer){
        return manufacturerRepository.update(manufacturer);
    }

    public List<Manufacturer> findManufacturersByName(String name){
        return manufacturerRepository.findManufacturersByName(name);
    }


    public void removeManufacturer(Manufacturer manufacturer){
        manufacturerRepository.delete(manufacturer);
    }
}
