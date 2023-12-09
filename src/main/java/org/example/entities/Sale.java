package org.example.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Date sale_date;


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

    public Sale(Date sale_date, Customer customer) {
        this.sale_date = sale_date;
        this.customer = customer;
//        this.products = products;
    }

    public Sale() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sales_date) {
        this.sale_date = sales_date;
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


