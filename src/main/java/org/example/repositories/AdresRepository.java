package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.entities.Adress;

import java.util.List;


public class AdresRepository extends Repository<Adress> {

    private EntityManager entityManager;
    private EntityManagerFactory emf;



    public AdresRepository(EntityManager entityManager) {
        super(entityManager);
      this.entityManager = entityManager;
    }

    @Override
    public Adress update(Adress adress) {
        try {
            Adress adressToUpdate = find(adress.getId(), Adress.class);
            entityManager.getTransaction().begin();

            adressToUpdate.setStreetname(adress.getStreetname());
            adressToUpdate.setHousenumber(adress.getHousenumber());
            adressToUpdate.setNeighborhood(adressToUpdate.getNeighborhood());

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
        return find(adress.getId(), Adress.class);
    }










    public List<Adress> findAdressesByStreetName(String streetname){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select adress from Adress adress where lower(streetname)=lower(:p1) ");
        query.setParameter("p1", streetname);

        List<Adress> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }


    public Adress findAdressByStreetNameAndHouseNumber(String streetName, int houseNumber){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("" +
                "select  adress " +
                "from   Adress adress " +
                "where  lower(streetname)=lower(:p1)" +
                "and    housenumber = :p2");
        query.setParameter("p1", streetName);
        query.setParameter("p2", houseNumber);

        List<Adress> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        if(resultList.isEmpty()){
            return null;
        }
        return resultList.get(0);
    }

    public void close(){
        this.entityManager.close();
//        this.emf.close();
    }



}
