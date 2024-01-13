package org.example;

import org.example.entities.Adress;
import org.example.entities.SaleProducts;
import org.example.observerpattern.SmsNotificationListener;
import org.example.service.AdressService;
import org.example.service.CustomerService;
import org.example.ui.MainMenuManagement;
import org.example.ui.SaleManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MainMenuManagement MainMenuManagement = new MainMenuManagement();
        MainMenuManagement.handleUserInput();



    }
}