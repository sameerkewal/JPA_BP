package org.example;

import org.example.ui.MainMenuManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MainMenuManagement MainMenuManagement = new MainMenuManagement();
        MainMenuManagement.handleUserInput();

//        CustomerService customerService = new CustomerService();
//        AdressService adressService = new AdressService();
//        customerService.addCustomer(new Customer("test", "print", "115", adressService.findAdress(1)));


    }
}