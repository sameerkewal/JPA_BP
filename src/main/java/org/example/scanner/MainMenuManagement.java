package org.example.scanner;

import java.util.Scanner;

public class MainMenuManagement {

    private final Scanner scanner;
    private final AdressManagement adressManagement;
    private final ManufacturerManagement manufacturerManagement;
    private final CustomerManagement customerManagement;
    private final ProductManagement productManagement;

    private final SaleManagement saleManagement;

    private final UtilInputHandler utilInputHandler;




    public MainMenuManagement() {

        this.scanner = new Scanner(System.in);
        this.adressManagement = new AdressManagement(this.scanner);
        this.manufacturerManagement = new ManufacturerManagement(this.scanner);
        this.customerManagement = new CustomerManagement(this.scanner);
        this.productManagement = new ProductManagement(this.scanner);
        this.saleManagement = new SaleManagement(this.scanner);

        utilInputHandler = new UtilInputHandler(this.scanner);




    }

    public void handleUserInput() {

            System.out.println("Welcome to UBuy, what would you like to do today?:");
            System.out.println("1. Sale Management");
            System.out.println("2. Product Management");
            System.out.println("3. Customer Management");
            System.out.println("4. Adress Management");
            System.out.println("5. Manufacturer Management");
            System.out.println("0. Exit");

            // Get user choice
            int choice = utilInputHandler.getUserIntegerChoice();

            // Handle user choice
            switch (choice) {
                case 1:
                    saleManagement.mainSaleManagement();
                    break;
                case 2:
                    productManagement.mainProductManagement();
                    break;
                case 3:
                    customerManagement.mainCustomerManagement();
                    break;
                case 4:
                    adressManagement.mainAdressManagement();
                    break;
                case 5:
                    manufacturerManagement.mainManufacturerManagement();
                    break;
                case 0:
                    // Exit or cleanup logic
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    handleUserInput(); // Recursive call to handle input again
            }

            if(utilInputHandler.goBackToMainMenu()){
                handleUserInput();
            }
        }










}
