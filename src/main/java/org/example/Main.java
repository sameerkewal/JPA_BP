package org.example;

import org.example.scanner.UserInputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInputHandler userInputHandler = new UserInputHandler();
        userInputHandler.handleUserInput();

//        AdressManagement adressManagement = new AdressManagement(scanner);
//        adressManagement.adressManagement();


    }
}