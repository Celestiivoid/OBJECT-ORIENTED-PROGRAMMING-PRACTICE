package PETCARESYSTEMV2;
import java.util.Scanner;

public class PetCareSystemV2Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PetServiceV2 serviceV2 = new PetServiceV2();
        while(true) {
            System.out.println("=====PET-CARE-SYSTEM-V2=====");
            System.out.println("[1] Add Pet");
            System.out.println("[2] Feed Pet");
            System.out.println("[3] Play With Pet");
            System.out.println("[4] Put Pet to Rest");
            System.out.println("[5] View Pets");
            System.out.println("[6] Search Pet");
            System.out.println("[7] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> serviceV2.addPet();
                case 2 -> serviceV2.feedPet();
                case 3 -> serviceV2.playWithPet();
                case 4 -> serviceV2.restPet();
                case 5 -> serviceV2.viewPets();
                case 6 -> serviceV2.searchPet();
                case 7 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String exit = scanner.nextLine();

                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }
}
