import java.util.Scanner;
import java.util.ArrayList;
class PetService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Pet> pets = new ArrayList<>();

    void displayPet() {
        for(int i = 0; i < pets.size(); i++) {
            Pet display = pets.get(i);
            System.out.println((i + 1) + ".) " + " Name: " + display.getPetName() 
            + " | Type: " + display.getPetType() 
            +  " | Hunger: " + display.getPetHunger());
        }
    }
    void addPet() {
        while(true) {
            System.out.println("Enter pet name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            System.out.println("Enter pet type: ");
            String type = scanner.nextLine();

            if(type.isEmpty()) {
                System.out.println("Type field cannot be empty.");
                continue;
            }

            System.out.println("Enter hunger level: ");
            double hunger;

            try {
                hunger = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(hunger <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }
            Pet newPet = new Pet(name, type, hunger);
            pets.add(newPet);
            return;
        }
    }
    void viewPet() {

        if(pets.isEmpty()) {
            System.out.println("No pets at the moment.");
            return;
        }

        displayPet();
    }
    void feedPet() {

        if(pets.isEmpty()) {
            System.out.println("No pets to feed.");
            return;
        }

        while(true) {

            displayPet();

            System.out.println("Pick a pet to feed: ");
            int choose;

            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(choose < 1 || choose > pets.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Pet selectedPet = pets.get(choose - 1);

            System.out.println("Enter amount to feed: ");
            double feed;

            try {
                feed = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            String result = selectedPet.eat(feed);
            System.out.println(result);
            return;
        }
    }
    void searchPet() {
        boolean findPet = false;
        System.out.println("Search a pet by name: ");
        String find = scanner.nextLine();

        for(int i = 0; i < pets.size(); i++) {
            Pet findpetName = pets.get(i);
            if(find.equalsIgnoreCase(findpetName.getPetName())) {
                findPet = true; 
                System.out.println("Pet found!"); 
                System.out.println("Name: " + findpetName.getPetName() 
                + " | Type: " 
                + findpetName.getPetType());
                return;
            }
        }
        if(!findPet) {
            System.out.println("Pet not found.");
            return;
        }
    }
}