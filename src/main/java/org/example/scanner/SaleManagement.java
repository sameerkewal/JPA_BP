package org.example.scanner;

import org.example.entities.Product;
import org.example.servies.ProductService;

import java.util.Scanner;

public class SaleManagement {
    private final Scanner scanner;
    private final UtilInputHandler utilInputHandler;

    private final ProductManagement productManagement;
    private final ProductService productService;



    public SaleManagement(Scanner scanner) {
        this.scanner = scanner;
        this.utilInputHandler = new UtilInputHandler(this.scanner);
        this.productManagement = new ProductManagement(this.scanner);
        this.productService = new ProductService();

    }

    public void mainCustomerManagement(){
        System.out.println("0. Exit");
        System.out.println("1. Register New Sale");


        int choice = utilInputHandler.getUserIntegerChoice();


        switch (choice){
            case 0:
                return;
            case 1:
                registerNewSale();
        }

    }

    private void registerNewSale() {
        System.out.println("Do you know the ID of item to add to sale?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Back To Sale Management");

        int doesUserKnowIdOfProduct = utilInputHandler.getUserIntegerChoice();

        if(doesUserKnowIdOfProduct == 2){
                productManagement.findProductChoices();
                registerNewSale();
        } else if (doesUserKnowIdOfProduct == 1) {
            System.out.println("Provide ID of item to add to sale: ");
            int idOfProductToAdd = utilInputHandler.getUserIntegerChoice();
            Product productToAddToSale = productService.find(idOfProductToAdd);

            if(productToAddToSale == null){
                System.out.println("No Product with that ID exists. Please try again");
                registerNewSale();
            }else{

            }
        }

        String productToAddToSale = utilInputHandler.getUserStringChoice();




        System.out.println("Item Quantity: ");

    }
}
