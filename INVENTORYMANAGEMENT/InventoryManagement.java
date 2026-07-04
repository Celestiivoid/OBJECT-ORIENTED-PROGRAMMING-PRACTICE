package INVENTORYMANAGEMENT;
import java.util.Scanner;

class InventoryManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        while(true) {
            System.out.println("=====INVENTORY-SYSTEM=====");
            System.out.println("[1] Add Product");
            System.out.println("[2] View Products");
            System.out.println("[3] Buy Product");
            System.out.println("[4] Restock Product");
            System.out.println("[5] Search Product");
            System.out.println("[6] Exit");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            switch(option) {
                case 1 -> service.addProduct();
                case 2 -> service.viewProduct();
                case 3 -> service.buyProduct();
                case 4 -> service.restockProduct();
                case 5 -> service.searchProduct();
                case 6 -> {
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