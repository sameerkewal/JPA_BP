package org.example.scanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.math.BigDecimal;

public class UtilInputHandler {

    private final Scanner scanner;


    public UtilInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    protected int getUserIntegerChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    protected String getUserStringChoice() {
        while (scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a string.");
            scanner.next(); // Consume invalid input
        }
        return scanner.next();
    }







    public boolean goBackToMainMenu(){
        System.out.println("Do you want to go back to the main menu?");
        System.out.println("1. Yes");
        System.out.println("2. Exit");


        int doesUserWantToGoBackToMainMenu = getUserIntegerChoice();
        return doesUserWantToGoBackToMainMenu == 1;
    }


    protected boolean stayInSpecificManagement(String management){
        System.out.println("Do you want to keep managing " + management + "?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int doesUserWantToKeepManaging = getUserIntegerChoice();
        if(doesUserWantToKeepManaging == 1){
            return true;
        } else if (doesUserWantToKeepManaging == 2) {
            return false;
        }
        return false;
    }

    public BigDecimal getUserBigDecimalChoice() {
        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Invalid input. Please enter a valid decimal number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextBigDecimal();
    }


    public LocalDate getUsersDateChoice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");





        LocalDate localDate = null;

        // Loop until a valid date is entered
        while (localDate == null) {
            System.out.println("Enter the date in dd-MM-yyyy format(example: 09-12-2023)");
            String dateString = scanner.next();

            try {
                // Parse the string into a LocalDateTime object
                localDate = LocalDate.parse(dateString, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        return localDate;
    }

    }

