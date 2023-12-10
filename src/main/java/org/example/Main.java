package org.example;

import org.example.entities.Adress;
import org.example.entities.Customer;
import org.example.entities.SaleProducts;
import org.example.scanner.SaleManagement;
import org.example.scanner.UserInputHandler;
import org.example.service.AdressService;
import org.example.service.CustomerService;
import org.example.service.SaleProductsService;
import org.example.service.SaleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInputHandler userInputHandler = new UserInputHandler();
        userInputHandler.handleUserInput();

//        CustomerService customerService = new CustomerService();
//        AdressService adressService = new AdressService();
//        customerService.addCustomer(new Customer("test", "print", "115", adressService.findAdress(1)));


    }
}