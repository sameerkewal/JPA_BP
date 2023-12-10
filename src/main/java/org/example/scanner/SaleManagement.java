package org.example.scanner;

import org.example.entities.Customer;
import org.example.entities.Product;
import org.example.entities.Sale;
import org.example.entities.SaleProducts;
import org.example.service.CustomerService;
import org.example.service.ProductService;
import org.example.service.SaleProductsService;
import org.example.service.SaleService;


import java.time.LocalDateTime;
import java.util.Scanner;

public class SaleManagement {
    private final Scanner scanner;
    private final UtilInputHandler utilInputHandler;

    private final ProductManagement productManagement;
    private final ProductService productService;
    private final CustomerService customerService;
    private final CustomerManagement customerManagement;
    private final SaleService saleService;
    private final SaleProductsService saleProductsService;



    public SaleManagement(Scanner scanner) {
        this.scanner = scanner;
        this.utilInputHandler = new UtilInputHandler(this.scanner);
        this.productManagement = new ProductManagement(this.scanner);
        this.customerManagement = new CustomerManagement(this.scanner);
        this.customerService = new CustomerService();
        this.productService = new ProductService();
        this.saleService = new SaleService();
        this.saleProductsService = new SaleProductsService();
    }

    public void mainSaleManagement(){
        System.out.println("0. Exit");
        System.out.println("1. Register New Sale");


        int choice = utilInputHandler.getUserIntegerChoice();


        switch (choice){
            case 0:
                return;
            case 1:
                registerNewSale();
                break;
        }

        if(utilInputHandler.stayInSpecificManagement("sales")){
            mainSaleManagement();
        }

    }

    private void registerNewSale(){
        Customer customerToAddToSale = addCustomerToSale();
        Sale sale = addSale(customerToAddToSale);

        addItemsToSale(sale);

        while(true){
            System.out.println("Do you want to add another item to the sale?");
            System.out.println("1. Yes");
            System.out.println("2. Finish Transaction");
            System.out.println("3. Cancel Transaction");
            int choice = utilInputHandler.getUserIntegerChoice();

//            Do you know the ID of item to add to sale? ->correct
            //Do you want to add another item to the sale? -> correct

            switch (choice){
                case 1:
                    addItemsToSale(sale);
                    break;
                case 2:
                    if(!(saleProductsService.checkIfSaleHasProductsAddedToIt(sale))){
                        saleService.delete(sale);
                    }
                    return;
                case 3:
                    saleProductsService.deleteSaleProducts(sale);
                    saleService.delete(sale);
                    return;
            }

        }
    }

    private void addItemsToSale(Sale sale) {
        System.out.println("Do you know the ID of item to add to sale?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Cancel Transaction");

        int doesUserKnowIdOfProduct = utilInputHandler.getUserIntegerChoice();

        if(doesUserKnowIdOfProduct == 2){
                 productManagement.findProductChoices();
                 addItemsToSale(sale);

        } else if (doesUserKnowIdOfProduct == 1) {

            System.out.println("Provide ID of item to add to sale: ");
            int idOfProductToAdd = utilInputHandler.getUserIntegerChoice();
            Product productToAddToSale = productService.find(idOfProductToAdd);

            if(productToAddToSale == null){
                System.out.println("No Product with that ID exists. Please try again");
                 addItemsToSale(sale);
            }else{
                System.out.println("Product quantity to add to sale: ");
                int productQuantity = utilInputHandler.getUserIntegerChoice();

                saleProductsService.add(new SaleProducts(sale, productToAddToSale, productQuantity));
            }
        } else if (doesUserKnowIdOfProduct == 3) {
                saleProductsService.deleteSaleProducts(sale);
                saleService.delete(sale);
                mainSaleManagement();
            }

         else{
            addItemsToSale(sale);
        }
    }




    private Customer addCustomerToSale(){

        System.out.println("Do you know the ID of the customer to add to sale?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Add Customer");


        int doesUserKnowIdOfCustomer = utilInputHandler.getUserIntegerChoice();

        if(doesUserKnowIdOfCustomer == 2){
            customerManagement.findCustomerByFirstAndLastName();
            return addCustomerToSale();

        } else if (doesUserKnowIdOfCustomer == 1) {
            System.out.println("Provide ID of customer to add to sale: ");
            int idOfCustomerToAdd = utilInputHandler.getUserIntegerChoice();
            Customer customerToAddToSale = customerService.find(idOfCustomerToAdd);

            if(customerToAddToSale == null){
                System.out.println("No Customer with that ID exists. Please try again");
                return addCustomerToSale();
            }else{
                System.out.println(customerToAddToSale);
                return customerToAddToSale;
            }
        } else if (doesUserKnowIdOfCustomer == 3) {
            return customerManagement.addCustomer();
        }else {
            return addCustomerToSale();
        }


        
    }


    public Sale addSale(Customer customerToAddToSale){
        return saleService.add(new Sale(LocalDateTime.now(), customerToAddToSale));

    }
}
