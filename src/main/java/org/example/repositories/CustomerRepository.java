package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Customer;

import java.util.List;

public class CustomerRepository extends Repository<Customer> {

    private EntityManager entityManager;


    public CustomerRepository(EntityManager entityManager){
        super(entityManager);
        this.entityManager = entityManager;
    }




    @Override
    public Customer update(Customer customer) {
        Customer customerToUpdate = find(customer.getId(), Customer.class);

        entityManager.getTransaction().begin();

        customerToUpdate.setAdress(customer.getAdress());
        customerToUpdate.setFirstname(customer.getFirstname());
        customerToUpdate.setLastname(customer.getLastname());
        customerToUpdate.setPhonenumber(customer.getPhonenumber());

        entityManager.getTransaction().commit();

        return find(customer.getId(), Customer.class);
    }


    public List<Customer>findCustomersByFirstAndLastName(String firstName, String lastName){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("" +
                "select  cmr " +
                "from   Customer cmr " +
                "where  lower(firstname)=lower( :p1) " +
                "and    lower(lastname)=lower( :p2)");

        query.setParameter("p1", firstName);
        query.setParameter("p2", lastName);

        List<Customer>resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;



    }
}
