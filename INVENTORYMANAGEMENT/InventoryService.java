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

            System.out.println("Enter product quantity: ");
            int quantity;

            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            Inventory newProduct = new Inventory(product, price, quantity);
            newProduct.addProductRule(price, quantity);
            inventory.add(newProduct);
            return;
        }
    }
    void viewProduct() {
        while(true) {
            if(inventory.isEmpty()) {
                System.out.println("No products are available.");
                return;
            }

            for(int i = 0; i < inventory.size(); i++) {
                Inventory view = inventory.get(i);
                System.out.println((i + 1) + ".) " + " Product Name: " + view.getProductName() 
                + " | Price: " + view.getProductPrice() 
                + " | Quantity: " + view.getProductQuantity());
            }
        }
    }
    void searchProduct() {

    }
    void restockProduct() {

    }
}
