import java.util.Scanner;

/* A OOP PET CARE SYSTEM */

public class OOPCHL4 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PetService service = new PetService();
        while(true) {
            System.out.println("=====PET-CARE-SYSTEM=====");
            System.out.println("[1] Add Pet");
            System.out.println("[2] View Pet");
            System.out.println("[3] Feed Pet");
            System.out.println("[4] Search Pet");
            System.out.println("[5] Exit");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 5) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.addPet();
                case 2 -> service.viewPet();
                case 3 -> service.feedPet();
                case 4 -> service.searchPet();
                case 5 -> {
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
