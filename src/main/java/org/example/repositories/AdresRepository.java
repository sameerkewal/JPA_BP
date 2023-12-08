package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Adress;



public class AdresRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;



    public AdresRepository(EntityManager entityManager) {

      this.entityManager = entityManager;
    }

    public Adress addAdres(Adress adress){
        entityManager.getTransaction().begin();
        entityManager.merge(adress);
        entityManager.getTransaction().commit();
        return adress;
    }


    public Adress findAdress(Integer id){
        return entityManager.find(Adress.class, id);

    }


    public Adress updateAdress(Adress adress) {
        Adress adressToUpdate = findAdress(adress.getId());
        entityManager.getTransaction().begin();


        adressToUpdate.setStraatnaam(adress.getStraatnaam());
        adressToUpdate.setHuisnummer(adress.getHuisnummer());
        adressToUpdate.setWijk(adressToUpdate.getWijk());


        entityManager.getTransaction().commit();
        return adressToUpdate;

    }

    public void deleteAdres(Adress adress){
        entityManager.getTransaction().begin();
        entityManager.remove(adress);
        entityManager.getTransaction().commit();


    }

    public void close(){
        this.entityManager.close();
//        this.emf.close();
    }



}
