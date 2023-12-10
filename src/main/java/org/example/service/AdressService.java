package org.example.service;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Adress;
import org.example.repositories.AdresRepository;

import java.util.List;

public class AdressService {

    private final AdresRepository adresRepository;


    public AdressService() {
        this.adresRepository = new AdresRepository(JPAConfiguration.getEntityManager());

    }



    public Adress createAdress(Adress adress){
        return adresRepository.addAdres(adress);
    }

    public Adress updateAdress(Adress adress){
        return adresRepository.updateAdress(adress);
    }

    public void deleteAdress(Adress adress){
        adresRepository.deleteAdres(adress);
    }


    public Adress findAdress(Integer id){
        return adresRepository.findAdress(id);
    }


    public List<Adress> findAdressesByStreetName(String streetname){
        return adresRepository.findAdressesByStreetName(streetname);
    }

    public Adress findAdressesByStreetNameAndHouseNumber(String streetName, int houseNumber){
        return adresRepository.findAdressByStreetNameAndHouseNumber(streetName, houseNumber);
    }



}
