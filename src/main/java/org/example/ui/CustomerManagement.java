package org.example.ui;

import org.example.entities.Adress;
import org.example.entities.Customer;
import org.example.service.AdressService;
import org.example.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerManagement {

    private final Scanner scanner;

    private final UtilInputHandler utilInputHandler;

    private final CustomerService customerService;

    private final AdressService adressService;

    public CustomerManagement(Scanner scanner) {
        this.scanner = scanner;
        this.customerService = new CustomerService();
        this.utilInputHandler = new UtilInputHandler(this.scanner);
        this.adressService = new AdressService();
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
                break;
            case 0:
                return;
            default:
                mainCustomerManagement();

        }

        if(utilInputHandler.stayInSpecificManagement("customers")){
            mainCustomerManagement();
        }
    }

    protected void findCustomerByFirstAndLastName() {
        System.out.println("Provide firstname: ");
        String firstName = utilInputHandler.getUserStringChoice();

        System.out.println("Provide lastname: ");
        String lastName = utilInputHandler.getUserStringChoice();

        List<Customer> customersByFirstAndLastName = customerService.findCustomersByFirstAndLastName(firstName, lastName);
        if(customersByFirstAndLastName.isEmpty()){
            System.out.println("No customers with that first and last name found");
        }else{
            customersByFirstAndLastName.forEach(System.out::println);

        }
    }

    public Customer addCustomer() {
        System.out.println("Provide firstname: ");
        String firstName = utilInputHandler.getUserStringChoice();

        System.out.println("Provide lastname: ");
        String lastName = utilInputHandler.getUserStringChoice();

        System.out.println("Provide phonenumber: ");
//        String phoneNumber = String.valueOf(utilInputHandler.getUserIntegerChoice());
          String phoneNumber = utilInputHandler.getUserStringChoice();

        System.out.println("Provide streetname of customer: ");
        String streetNameOfCustomer = utilInputHandler.getUserStringChoice();

        System.out.println("Provide housenumber of customer: ");
        int houseNumberOfCustomer = utilInputHandler.getUserIntegerChoice();

        Adress adressByStreetNameAndHouseNumber = adressService.findAdressesByStreetNameAndHouseNumber(streetNameOfCustomer, houseNumberOfCustomer);

        if(adressByStreetNameAndHouseNumber == null){
            System.out.println("That Address does not exist in the system");
            System.out.println("Please also provide the neighborhood so we can add it: ");
            String neighborhoodOfCustomer = utilInputHandler.getUserStringChoice();

            Adress adressAdded = adressService.createAdress(new Adress(streetNameOfCustomer, houseNumberOfCustomer, neighborhoodOfCustomer));
            Customer addedCustomer = customerService.addCustomer(new Customer(firstName, lastName, phoneNumber, adressAdded));
            System.out.println(addedCustomer);
            return addedCustomer;

        }else{
            Customer addedCustomer= customerService.addCustomer(new Customer(firstName, lastName, phoneNumber, adressByStreetNameAndHouseNumber));
            System.out.println(addedCustomer);
            return addedCustomer;
        }


    }
}
