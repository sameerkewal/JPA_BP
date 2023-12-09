package org.example.repositories;

import jakarta.persistence.EntityManager;

public abstract class Repository<T> {

    private EntityManager entityManager;

    public Repository(EntityManager entityManager){

        this.entityManager = entityManager;
    }

    public T add(T object){
        T addedObject = null;
        try {
            entityManager.getTransaction().begin();
             addedObject = entityManager.merge(object);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return addedObject;
    }

    public void delete(T object){
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }

    public T find(Integer id, Class<T>entityclass){
        return entityManager.find(entityclass, id);
    }

    public abstract T update(T object);
}
