package INVENTORYMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;

class InventoryService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Inventory> inventory = new ArrayList<>();
    void addProduct() {
        while(true) {
            System.out.println("=====ADD-PRODUCT=====");
            System.out.println("Enter product name: ");
            String product = scanner.nextLine();

            if(product.isEmpty()) {
                System.out.println("Product field cannot be empty.");
                continue;
            }

            System.out.println("Enter product price: ");
            double price;

            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(price <= 0.0) {
                System.out.println("Cannot set 0 or negative numbers for price field.");
                continue;
            }

            System.out.println("Enter product quantity: ");
            int quantity;

            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(quantity <= 0.0) {
                System.out.println("Cannot set 0 or negative numbers for quantity field.");
                continue;
            }

            Inventory newProduct = new Inventory(product, price, quantity);
            inventory.add(newProduct);
            System.out.println("Successfully added product.");
            return;
        }
    }
    void viewProduct() {

    }
    void buyProduct() {

    }
    void restockProduct() {

    }
    void searchProduct() {

    }
}