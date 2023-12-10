package org.example;

import org.example.scanner.UserInputHandler;
import org.example.service.SaleProductsService;
import org.example.service.SaleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        UserInputHandler userInputHandler = new UserInputHandler();
//        userInputHandler.handleUserInput();

        SaleService saleService = new SaleService();
        SaleProductsService saleProductsService = new SaleProductsService();

        saleProductsService.getMostValuableCustomers();
//
//        Sale sale = saleService.find(36);
//        saleProductsService.deleteSaleProducts(sale);
//        System.out.println(saleProductsService.checkIfSaleHasProductsAddedToIt(sale));

//        CustomerManagement customerManagement = new CustomerManagement(new Scanner(System.in));






    }
}