package PETCARESYSTEMV2;
import java.util.Scanner;
import java.util.ArrayList;

class PetServiceV2 {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PetV2> petv2s = new ArrayList<>();
    
    void addPet() {
        while(true) {
            System.out.println("=====ADD-PET=====");
            System.out.println("Enter pet name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < petv2s.size(); i++) {
                PetV2 auth = petv2s.get(i);
                if(name.equals(auth.getPetName())) {
                    System.out.println("Pet name already exist.");
                    return;
                }
            }

            System.out.println("Enter pet type: ");
            String type = scanner.nextLine();

            if(type.isEmpty()) {
                System.out.println("Type field cannot be empty.");
                continue;
            }

            PetV2 newPet = new PetV2(name, type);
            petv2s.add(newPet);
            System.out.println("Successfully added " + name);
            return;
        }
    }
    void globalPetViewing() {
        if(petv2s.isEmpty()) {
            System.out.println("No pets to show.");
            return;
        }
        for(int i = 0; i < petv2s.size(); i++) {
            PetV2 global = petv2s.get(i);
            System.out.println("Pet name: " + global.getPetName() 
            + " | Pet type: " + global.getPetType() 
            + " | Pet hunger: " + global.getHungerLevel() 
            + " | Pet energy: " + global.getEnergyLevel() 
            + " | Pet mood: " + global.petMood());
        }
    }
    void feedPet() {
        while(true) {
            System.out.println("=====FEED-PET=====");

            if(petv2s.isEmpty()) {
                globalPetViewing();
                return;
            }

            globalPetViewing();
            System.out.println("Pick a pet to feed: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > petv2s.size()) {
                System.out.println("Out of range.");
                continue;
            }

            PetV2 selectedPet = petv2s.get(option - 1);

            System.out.println("Enter amount to feed: ");
            double amount;

            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }
            String result = selectedPet.feed(amount);
            System.out.println(result);
            return;
        }
    }
    void playWithPet() {
        while(true) {
            System.out.println("=====PLAY-WITH-PET=====");
            if(petv2s.isEmpty()) {
                globalPetViewing();
                return;
            }

            globalPetViewing();
            System.out.println("Pick a pet to play with: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > petv2s.size()) {
                System.out.println("Out of range.");
                continue;
            }

            PetV2 selectedPet = petv2s.get(option - 1);
            String result = selectedPet.play();
            System.out.println(result);
            return;
        }
    }
    void restPet() {
        while(true) {
            System.out.println("=====PET-RESTING-AREA=====");
            if(petv2s.isEmpty()) {
                globalPetViewing();
                return;
            }
            globalPetViewing();
            System.out.println("Pick a pet to put to rest: ");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > petv2s.size()) {
                System.out.println("Out of range.");
                continue;
            }

            PetV2 selectedPet = petv2s.get(option -1 );
            String result = selectedPet.rest();
            System.out.println(result);
            return;
        }
    }
    void viewPets() {
        if(petv2s.isEmpty()) {
            globalPetViewing();
        }

        for(int i = 0; i < petv2s.size(); i++) {
            PetV2 view = petv2s.get(i);
            System.out.println("====================");
            view.displayPet();
            System.out.println("====================");
        }
    }
    void searchPet() {
        while(true) {
            System.out.println("=====SEARCH-PET=====");
            System.out.println("Enter pet name: ");
            String search = scanner.nextLine();

            if(search.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                continue;
            }

            for(int i = 0; i < petv2s.size(); i++) {
                PetV2 searchPet = petv2s.get(i);
                if(search.equalsIgnoreCase(searchPet.getPetName())) {
                    System.out.println("Pet found!");
                    searchPet.displayPet();
                    return;
                }
            }
            System.out.println("Pet not found.");
            return;
        }
    }
}
