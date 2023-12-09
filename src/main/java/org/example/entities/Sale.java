package org.example.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    private LocalDateTime sale_date;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "sale")
    private Set<SaleProducts> saleProducts = new HashSet<>();


    public Set<SaleProducts> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(Set<SaleProducts> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public Sale(LocalDateTime sale_date, Customer customer) {
        this.sale_date = sale_date;
        this.customer = customer;
//        this.products = products;
    }

    public Sale() {

    }

    public LocalDateTime getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDateTime sale_date) {
        this.sale_date = sale_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", sales_date=" + sale_date +
                ", customer=" + customer +
//                ", products=" + products +
                '}';
    }




//    public void addProducts(Product product){
//        boolean added = products.add(product);
//
//        if(added){
//            product.
//        }
//    }



}


