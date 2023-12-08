package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.entities.Adress;

import java.util.List;


public class AdresRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;



    public AdresRepository(EntityManager entityManager) {

      this.entityManager = entityManager;
    }

    public Adress addAdres(Adress adress){
        entityManager.getTransaction().begin();
        Adress adressAdded = entityManager.merge(adress);
        entityManager.getTransaction().commit();
        return adressAdded;
    }


    public Adress findAdress(Integer id){
        return entityManager.find(Adress.class, id);

    }


    public Adress updateAdress(Adress adress) {
        Adress adressToUpdate = findAdress(adress.getId());
        entityManager.getTransaction().begin();


        adressToUpdate.setStreetname(adress.getStreetname());
        adressToUpdate.setHousenumber(adress.getHousenumber());
        adressToUpdate.setNeighborhood(adressToUpdate.getNeighborhood());


        entityManager.getTransaction().commit();
        return adressToUpdate;

    }

    public void deleteAdres(Adress adress){
        entityManager.getTransaction().begin();
        entityManager.remove(adress);
        entityManager.getTransaction().commit();


    }


    public List<Adress> findAdressesByStreetName(String streetname){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select adress from Adress adress where lower(streetname)=lower(:p1) ");
        query.setParameter("p1", streetname);
        List<Adress> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public void close(){
        this.entityManager.close();
//        this.emf.close();
    }



}
