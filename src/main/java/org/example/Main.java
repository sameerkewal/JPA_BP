package org.example;

import org.example.entities.Customer;
import org.example.scanner.CustomerManagement;
import org.example.scanner.UserInputHandler;
import org.example.servies.ProductService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInputHandler userInputHandler = new UserInputHandler();
        userInputHandler.handleUserInput();

//        CustomerManagement customerManagement = new CustomerManagement(new Scanner(System.in));



//        ProductService productService = new ProductService();
//        productService.findProductByManufacturer(null);

//        AdressManagement adressManagement = new AdressManagement(scanner);
//        adressManagement.adressManagement();


    }
}