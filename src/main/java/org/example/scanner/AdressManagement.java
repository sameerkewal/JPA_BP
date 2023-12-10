package org.example.scanner;

import org.example.entities.Adress;
import org.example.service.AdressService;

import java.util.List;
import java.util.Scanner;


public class AdressManagement {
    private final Scanner scanner;
    private final AdressService adressService;
    
    private final UtilInputHandler utilInputHandler;

    public AdressManagement(Scanner scanner) {
        this.scanner = scanner;
        this.adressService = new AdressService();
        utilInputHandler = new UtilInputHandler(this.scanner);
        
    }

    public void adressManagement() {

            System.out.println("Adress Management: ");
            System.out.println("0. Exit");
            System.out.println("1. Add New Adress");
            System.out.println("2. Update Adress");
            System.out.println("3. Find Adress Details by streetname");
            System.out.println("4. Find Adress Details by streetname and housenumber");

            int choice = utilInputHandler.getUserIntegerChoice();

            switch (choice) {
                case 1:
                    addAdress();
                    break;

                case 2:
                    updateAdress();
                    break;


                case 3:
                    findAdressByStreetName();
                    break;
                case 4:
                    findAdressesByStreetNameAndHouseNumber();
                    break;
                case 0:
                    return;
//                    break;

            }


            if(utilInputHandler.stayInSpecificManagement("addresses")){
                adressManagement();
            }

        }

    private void findAdressesByStreetNameAndHouseNumber() {
        System.out.println("Provide streetname: ");
        String streetName = utilInputHandler.getUserStringChoice();

        System.out.println("Provide housenumber: ");
        int houseNumber = utilInputHandler.getUserIntegerChoice();

        Adress adressByStreetNameAndHouseNumber = adressService.findAdressesByStreetNameAndHouseNumber(streetName, houseNumber);
        if(adressByStreetNameAndHouseNumber == null){
            System.out.println("The combination of housenumber and streetname does not exist in the system");
        }else{
            System.out.println(adressByStreetNameAndHouseNumber);
        }

    }


    private void addAdress(){
            System.out.println("Provide streetname: (cannot be empty)");
            String streetName = utilInputHandler.getUserStringChoice();

            System.out.println("Provide housenumber: (cannot be empty)");
            int houseNumber = utilInputHandler.getUserIntegerChoice();


            System.out.println("Provide Neighborhood: ");
            String neighborhood = utilInputHandler.getUserStringChoice();

            Adress adressAdded = adressService.createAdress(new Adress(streetName, houseNumber, neighborhood));
            System.out.println(adressAdded);

        }



    private void updateAdress() {

        System.out.println("Do you know the ID of the adress to update?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Back To Adress Management");



        int doesUserKnowIdOfAdress = utilInputHandler.getUserIntegerChoice();
        if(doesUserKnowIdOfAdress == 2){
            findAdressByStreetName();
            updateAdress();
        } else if (doesUserKnowIdOfAdress == 1) {
            System.out.println("ID of adress to update: ");
            int idOfAdressToUpdate = utilInputHandler.getUserIntegerChoice();
            Adress adressToUpdate = adressService.findAdress(idOfAdressToUpdate);
            if (adressToUpdate == null) {
                System.out.println("No Adress with that ID exists. Please try again");
                updateAdress();
            } else {


                System.out.println("new Streetname: ");
                String newStreetName = utilInputHandler.getUserStringChoice();

                System.out.println("new Housenumber: ");
                Integer newHouseNumber = utilInputHandler.getUserIntegerChoice();

                System.out.println("new Neighborhood: ");
                String newNeighborHood = utilInputHandler.getUserStringChoice();


                adressToUpdate.setHousenumber(newHouseNumber);

                adressToUpdate.setStreetname(newStreetName);
                adressToUpdate.setNeighborhood(newNeighborHood);

                Adress updatedAdress = adressService.updateAdress(adressToUpdate);
                System.out.println(updatedAdress);


            }
        }else{
            adressManagement();
        }

    }

    private void findAdressByStreetName() {
        System.out.println("Enter the street name: ");
        String streetName = utilInputHandler.getUserStringChoice();
        List<Adress> adressesByStreetName = adressService.findAdressesByStreetName(streetName);
        if(adressesByStreetName.isEmpty()){
            System.out.println("No Streets with that name found");
        }

        for(Adress adress: adressesByStreetName){
            System.out.println(adress);
        }

    }


    
    
    
}
