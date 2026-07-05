package INVENTORYMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;

class InventoryService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> inventory = new ArrayList<>();
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

            Product newProduct = new Product(product, price, quantity);
            inventory.add(newProduct);
            System.out.println("Successfully added product.");
            return;
        }
    }
    void viewProduct() {
        if(inventory.isEmpty()) {
            System.out.println("No products are available.");
            return;
        }

        for(int i = 0; i < inventory.size(); i++) {
            Product view = inventory.get(i);
            System.out.println((i + 1) + ".) " + view.getProductName() 
            + " | Price: " + view.getProductPrice() 
            + " | Stock: " + view.getProductQuantity());
        }
    }
    void buyProduct() {
        while(true) {
            System.out.println("=====BUY-PRODUCT=====");

            if(inventory.isEmpty()) {
                viewProduct();
            }

            viewProduct();
            System.out.println("Choose product: ");
            int buy;

            try {
                buy = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(buy < 1 || buy > inventory.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Product selectedProduct = inventory.get(buy - 1);

            System.out.println("Enter amount to buy: ");
            int amount;

            try {
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            String result = selectedProduct.buy(amount);
            System.out.println(result);
            return;
        }
    }
    void restockProduct() {
        while(true) {
            System.out.println("=====RESTOCK-PRODUCT=====");

            if(inventory.isEmpty()) {
                viewProduct();
            }

            viewProduct();
            System.out.println("Pick a product to restock: ");
            int restock;

            try {
                restock = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(restock > inventory.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Product selectedRestock = inventory.get(restock - 1);

            System.out.println("Enter amount to restock: ");
            int amount;

            try {
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            String result = selectedRestock.restock(amount);
            System.out.println(result);
            return;
        }
    }
    void searchProduct() {
        while(true) {
            System.out.println("=====SEARCH-PRODUCT=====");
            System.out.println("Search a product by name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                return;
            }
            for (int i  = 0; i < inventory.size(); i++) {
                Product search = inventory.get(i);
                if(name.equalsIgnoreCase(search.getProductName())) {
                    System.out.println("Product found!");
                    search.displayProduct();
                    return;
                }
            }
            System.out.println("Product not found.");
            return;
        }
    }
}