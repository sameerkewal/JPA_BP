package org.example;

import org.example.entities.Adress;
import org.example.entities.SaleProducts;
import org.example.service.AdressService;
import org.example.service.CustomerService;
import org.example.ui.MainMenuManagement;
import org.example.ui.SaleManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
        MainMenuManagement MainMenuManagement = new MainMenuManagement();
        MainMenuManagement.handleUserInput();





//        CustomerService customerService = new CustomerService();
//        customerService.getAllCustomers();
//        AdressService adressService = new AdressService();
//        Adress adress = adressService.findAdress(9);
//        System.out.println(adress.getCustomers());


//        customerService.addCustomer(new Customer("test", "print", "115", adressService.findAdress(1)));


    }
}