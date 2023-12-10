package org.example.ui;

import org.example.entities.Manufacturer;
import org.example.service.ManufacturerService;

import java.util.Scanner;

public class ManufacturerManagement {

    private final Scanner scanner;
    private final ManufacturerService manufacturerService;

    private final UtilInputHandler utilInputHandler;


    public ManufacturerManagement(Scanner scanner) {
        this.scanner = scanner;
        this.manufacturerService = new ManufacturerService();
        utilInputHandler = new UtilInputHandler(this.scanner);
    }

    protected void mainManufacturerManagement(){
        System.out.println("Manufacturer Management: ");
        System.out.println("0. exit");
        System.out.println("1. Add New Manufacturer");
        System.out.println("2. Update Manufacturer");
        System.out.println("3. Delete Manufacturer");
        System.out.println("4. Find Manufacturer");

        int choice = utilInputHandler.getUserIntegerChoice();

        switch(choice){
            case 1:
                addManufacturer();
                break;

            case 2:
                updateManufacturer();
                break;

            case 3:
                deleteManufacturer();
                break;
            case 4:
                findManufacturerByManufacturerName();
                break;
            case 0:
                return;
            default:
                mainManufacturerManagement();
        }

        if(utilInputHandler.stayInSpecificManagement("manufacturers")){
            mainManufacturerManagement();
        }

    }

    private void findManufacturerByManufacturerName() {
        System.out.println("Enter the manufacturer name: ");
        String manufacturerName = utilInputHandler.getUserStringChoice();

        Manufacturer manufacturerByName = manufacturerService.findManufacturerByName(manufacturerName);

        if(manufacturerByName == null){
            System.out.println("No Manfacturers with that name found");
        }else{
            System.out.println(manufacturerByName);
        }


    }

    private void deleteManufacturer() {
        System.out.println("Do you know the ID of the Manufacturer to delete?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Back To Manufacturer Management");

        int doesUserKnowIdOfManufacturer = utilInputHandler.getUserIntegerChoice();

        if (doesUserKnowIdOfManufacturer == 2) {
            findManufacturerByManufacturerName();
            deleteManufacturer();
        } else if (doesUserKnowIdOfManufacturer == 1) {
            System.out.println("ID of manufacturer to delete: ");
            int idOfManufacturerToDelete = utilInputHandler.getUserIntegerChoice();
            Manufacturer manufacturerToDelete = manufacturerService.find(idOfManufacturerToDelete);

            if (manufacturerToDelete == null) {
                System.out.println("No Manufacturer with that ID exists. Please try again");
                updateManufacturer();
            } else {
                manufacturerService.removeManufacturer(manufacturerToDelete);
            }
        }
    }

    private void updateManufacturer() {

        System.out.println("Do you know the ID of the Manufacturer to update?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Back To Manufacturer Management");




        int doesUserKnowIdOfManufacturer = utilInputHandler.getUserIntegerChoice();

        if(doesUserKnowIdOfManufacturer == 2){
            findManufacturerByManufacturerName();
            updateManufacturer();
        } else if (doesUserKnowIdOfManufacturer == 1) {
            System.out.println("ID of manufacturer to update: ");
            int idOfManufacturerToUpdate = utilInputHandler.getUserIntegerChoice();
            Manufacturer manufacturerToUpdate = manufacturerService.find(idOfManufacturerToUpdate);

            if(manufacturerToUpdate == null){
                System.out.println("No Manufacturer with that ID exists. Please try again");
                updateManufacturer();
            }else{
                System.out.println("New Name: ");
                String newName = utilInputHandler.getUserStringChoice();

                System.out.println("New Country: ");
                String newCountry = utilInputHandler.getUserStringChoice();

                manufacturerToUpdate.setName(newName);
                manufacturerToUpdate.setCountry(newCountry);

                Manufacturer updatedManufacturer = manufacturerService.update(manufacturerToUpdate);
                System.out.println(updatedManufacturer);

            }
        }

    }

    private void addManufacturer() {
        System.out.println("Provide name of manufacturer: (cannot be empty)");
        String manufacturerName = utilInputHandler.getUserStringChoice();

        System.out.println("Provide location of manufacturer: (cannot be empty)");
        String manufacturerLocation = utilInputHandler.getUserStringChoice();




        Manufacturer manufacturerAdded = manufacturerService.addManufacturer(new Manufacturer(manufacturerName, manufacturerLocation));
        if(!(manufacturerAdded == null)){
            System.out.println(manufacturerAdded);
        }

    }



}
