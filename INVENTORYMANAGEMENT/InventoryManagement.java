package INVENTORYMANAGEMENT;
import java.util.Scanner;

public class InventoryManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        while(true) {
            System.out.println("=====INVENTORY-MANAGEMENT=====");
            System.out.println("[1] Add Product");
            System.out.println("[2] View Product");
            System.out.println("[3] Search Product");
            System.out.println("[4] Restock");
            System.out.println("[5] Exit");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range.");
                continue;
            }
            
            switch(option) {
                case 1 -> service.addProduct();
                case 2 -> service.viewProduct();
                case 3 -> service.searchProduct();
                case 4 -> service.restockProduct();
                case 5 -> {
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
