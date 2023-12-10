package org.example.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entities.Sale;
import org.example.entities.SaleProducts;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class SaleProductsRepository extends Repository<SaleProducts>{

    private final EntityManager entityManager;
    public SaleProductsRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public SaleProducts update(SaleProducts object) {
        return null;
    }


    public boolean checkIfSaleHasProductsAddedToIt(Sale sale){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "select sps from SaleProducts sps join Sale sle on sle.id=sps.sale.id where sle.id=:p1");

        System.out.println(sale.getId());
        query.setParameter("p1", sale.getId());

        List<SaleProducts> result  = query.getResultList();
        System.out.println(result);

        this.entityManager.getTransaction().commit();

        return !(result.isEmpty());
    }


    public void deleteSaleProducts(Sale sale){
        this.entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "delete from SaleProducts where sale.id=:p1");

        query.setParameter("p1", sale.getId());
        query.executeUpdate();
        this.entityManager.getTransaction().commit();

    }


    public void getSalesBasedOnProducts() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "select  sps.product_id,  p.name, sps.total_sold, p.price, (sps.total_sold*p.price) as total_value from (select  product.id as product_id, sum(quantity) as total_sold from SaleProducts group by product.id) sps join Product p on p.id = sps.product_id");

        List<Object[]> resultList = query.getResultList();
        entityManager.getTransaction().commit();

        for (Object[] obj : resultList) {
            Integer id = (Integer) obj[0];
            String name = (String) obj[1];
            Long sum = (Long) obj[2];
            BigDecimal price = (BigDecimal) obj[3];
            BigDecimal totalSold = (BigDecimal) obj[4];

            System.out.println(STR. "product: \{ name }, price: \{ price }, total sold: \{ sum }, value of total sold: \{ totalSold }" );

        }
    }

        public void getMostValuableCustomers(){
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("select cust_with_id.customer_id, cmr.firstname, cmr.lastname, cust_with_id.total from(select sle.customer.id as customer_id, sum(all_sales.total_worth) as total from(select sle.id as sale_id, sum(sps.quantity*p.price) as total_worth from Sale sle join SaleProducts sps on sps.sale.id=sle.id join Product  p on p.id = sps.product.id group by sle.id) all_sales join Sale sle on sle.id = all_sales.sale_id group by sle.customer.id)cust_with_id join Customer cmr on cust_with_id.customer_id=cmr.id order by cust_with_id.total desc");
            List<Object[]> resultList = query.getResultList();

            entityManager.getTransaction().commit();

            for (Object[] obj : resultList) {
                Integer id = (Integer) obj[0];
                String firstName = (String)obj[1];
                String lastName = (String)obj[2];
                BigDecimal totalWorth = (BigDecimal) obj[3];

                System.out.println(STR."id:\{id}, name:\{firstName} \{lastName}, total worth:\{totalWorth}");
        }


    }


    public SaleProducts getSalesBasedOnDate(LocalDateTime localDateTime){

        return null;
    }
}
