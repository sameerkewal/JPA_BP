package org.example.scanner;

import org.example.servies.CustomerService;

import java.util.Scanner;

public class CustomerManagement {

    private final Scanner scanner;

    private final UtilInputHandler utilInputHandler;

    private final CustomerService customerService;

    public CustomerManagement(Scanner scanner) {
        this.scanner = scanner;
        this.customerService = new CustomerService();
        this.utilInputHandler = new UtilInputHandler(this.scanner);
    }

    public void mainCustomerManagement(){
        System.out.println("Customer Management: ");
        System.out.println("0. Exit");
        System.out.println("1. Add Customer");
        System.out.println("2. Find Customer");

        int choice = utilInputHandler.getUserIntegerChoice();

        switch (choice){
            case 1:
                addCustomer();
                break;
            case 2:
                findCustomerByFirstAndLastName();
            case 0:
                return;

        }
    }

    private void findCustomerByFirstAndLastName() {
    }

    private void addCustomer() {

    }
}
