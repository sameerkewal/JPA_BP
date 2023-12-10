package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Manufacturer;
import org.example.entities.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository extends Repository<Product> {

    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = find(product.getId(), Product.class);
        entityManager.getTransaction().begin();

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setManufacturer(product.getManufacturer());

        entityManager.getTransaction().commit();
        return find(product.getId(), Product.class);
    }

    public List<Product> findProductByManufacturer(String manufacturer) {
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("" +
                "select  pdt  " +
                "from    Product pdt " +
                "join    Manufacturer  mfr on pdt.manufacturer.id=mfr.id " +
                "where lower(mfr.name)=lower(:p1)");

        query.setParameter("p1", manufacturer);

        List<Product> resultList = query.getResultList();


//        List<Object[]> resultList = query.getResultList();
//        System.out.println(resultList.size());
//
//        for (Object[] result : resultList) {
//            Product product = (Product) result[0];
//            Manufacturer manufacturer1 = (Manufacturer) result[1];
//
//            System.out.println("Product: " + product);
//            System.out.println("Manufacturer: " + manufacturer1);
//            System.out.println("------------------------------");
        entityManager.getTransaction().commit();
        return resultList;


    }

    public List<Product>getProductByName(String productName){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select  pdt from Product pdt where lower(name)=lower(:p1)");
        query.setParameter("p1", productName);

        List<Product> resultList = query.getResultList();
        this.entityManager.getTransaction().commit();
        return resultList;
    }

}

