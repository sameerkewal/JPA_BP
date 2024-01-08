package org.example.service;

import org.example.configuration.JPAConfiguration;
import org.example.entities.Customer;
import org.example.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository(JPAConfiguration.getEntityManager());
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.add(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.update(customer);
    }

    public Customer find(Integer id){
        return customerRepository.find(id, Customer.class);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public List<Customer> findCustomersByFirstAndLastName(String firstName, String lastName){
        return customerRepository.findCustomersByFirstAndLastName(firstName, lastName);
    }

    public void getAllCustomers(){
        customerRepository.getAllCustomers();
    }
}
