package org.example.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Date sales_date;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToMany(cascade= {CascadeType.ALL})
    @JoinTable(
            name = "sales_products",
            joinColumns = {@JoinColumn(name = "sales_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private Set<Product> products = new HashSet<>();
}
