package org.example.scanner;


import org.example.entities.Manufacturer;
import org.example.entities.Product;
import org.example.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {



        private final Scanner scanner;
        private final ProductService productService;
        private final ManufacturerService manufacturerService;

        private final UtilInputHandler utilInputHandler;

        public ProductManagement(Scanner scanner) {
            this.scanner = scanner;
            this.productService = new ProductService();
            this.manufacturerService = new ManufacturerService();
            utilInputHandler = new UtilInputHandler(this.scanner);

        }

    public void mainProductManagement() {

        System.out.println("product Management: ");
        System.out.println("0. Exit");
        System.out.println("1. Add New product");
        System.out.println("2. Update product");
        System.out.println("3. Find product Details by product name");
        System.out.println("4. Find product Details by manufacturer name");

        int choice = utilInputHandler.getUserIntegerChoice();

        switch (choice) {
            case 1:
                addproduct();
                break;

            case 2:
                updateProduct();
                break;


            case 3:
                findproductByName();
                break;
            case 4:
                findproductsByManufacturer();
                break;
            case 0:
                return;
//                    break;

        }


        if(utilInputHandler.stayInSpecificManagement("products")){
            mainProductManagement();
        }

    }

    private void findproductsByManufacturer() {
        System.out.println("Provide manufacturer name: ");
        String manufacturerName = utilInputHandler.getUserStringChoice();

        List<Product> productByManufacturer = productService.findProductByManufacturer(manufacturerName);
        if(!(productByManufacturer.isEmpty())){
            for(Product products: productByManufacturer){
                System.out.println(products);
            }
        }else{
            System.out.println("No Products with that manufacturer found");
        }


    }

    private void findproductByName() {
        System.out.println("Provide product name: ");
        String productName = utilInputHandler.getUserStringChoice();

        List<Product> productByName = productService.getProductByName(productName);
        if(!(productByName.isEmpty())){
            for(Product product: productByName){
                System.out.println(product);
            }
        }else{
            System.out.println("No products with that name found");
        }

    }

    private void updateProduct() {

        System.out.println("Do you know the ID of the product to update?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Back To Product Management");


        int doesUserKnowIdOfProduct = utilInputHandler.getUserIntegerChoice();
        if (doesUserKnowIdOfProduct == 2) {
            findProductChoices();
            updateProduct();

        } else if (doesUserKnowIdOfProduct == 1) {
            System.out.println("ID of Product to update: ");
            int idOfProductToUpdate = utilInputHandler.getUserIntegerChoice();
            Product productToUpdate = productService.find(idOfProductToUpdate);
            if (productToUpdate == null) {
                System.out.println("No Product with that ID exists. Please try again");
                updateProduct();
            } else {
                System.out.println("New Product Name: ");
                String newProductName = utilInputHandler.getUserStringChoice();

                System.out.println("New Product Price:" );
                BigDecimal newProductPrice = utilInputHandler.getUserBigDecimalChoice();

                System.out.println("New manufacturer name: ");
                String newManufacturerName = utilInputHandler.getUserStringChoice();

                Manufacturer newManufacturer = manufacturerService.findManufacturerByName(newManufacturerName);
                if(newManufacturer == null){
                    System.out.println("That Manufacturer does not exist in the system");
                    System.out.println("Please also provide the country so we can add it: ");
                    String countryOfManufacturer = utilInputHandler.getUserStringChoice();

                    Manufacturer manufacturAdded = manufacturerService.addManufacturer(new Manufacturer(newManufacturerName, countryOfManufacturer));
                    productToUpdate.setName(newProductName);
                    productToUpdate.setPrice(newProductPrice);
                    productToUpdate.setManufacturer(manufacturAdded);

                    System.out.println(productService.update(productToUpdate));
                } else{
                    productToUpdate.setName(newProductName);
                    productToUpdate.setPrice(newProductPrice);
                    productToUpdate.setManufacturer(newManufacturer);


                    System.out.println(productService.update(productToUpdate));

                }
            }
        }
    }

    protected void findProductChoices() {
        System.out.println("1. Find product Details by product name ");
        System.out.println("2. Find product Details by manufacturer name");

        int searchChoice = utilInputHandler.getUserIntegerChoice();

        switch (searchChoice){
            case 1:
                findproductByName();
                break;
            case 2:
                findproductsByManufacturer();
                break;
        }
    }

    private void addproduct() {
        System.out.println("Provide product name: ");
        String productName = utilInputHandler.getUserStringChoice();


        System.out.println("Provide product price: ");
        BigDecimal productPrice = utilInputHandler.getUserBigDecimalChoice();

        System.out.println("Provide manufacturer Name: ");
        String manufacturerName = utilInputHandler.getUserStringChoice();

        Manufacturer manufacturerByName = manufacturerService.findManufacturerByName(manufacturerName);

        if(manufacturerByName == null){
            System.out.println("That Manufacturer does not exist in the system");
            System.out.println("Please also provide the country so we can add it: ");
            String countryOfManufacturer = utilInputHandler.getUserStringChoice();

            Manufacturer manufacturAdded = manufacturerService.addManufacturer(new Manufacturer(manufacturerName, countryOfManufacturer));

            Product productAdded = productService.add(new Product(productName, productPrice, manufacturAdded));
        }else{
            productService.add(new Product(productName, productPrice, manufacturerByName));
        }

    }
}
