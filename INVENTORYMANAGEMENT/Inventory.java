package INVENTORYMANAGEMENT;

class Product {
    private String productName;
    private double productPrice;
    private int productQuantity;

    Product(String productName, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    String buy(int quantityAmount) {
        if(quantityAmount > productQuantity) {
            return "Insufficient quantity.";
        }
        if(quantityAmount <= 0) {
            return "Cannot set 0 or negative numbers.";
        }
        productQuantity -= quantityAmount;
        return "Successfully bought: " + productName;
    }
    String restock(int restockAmount) {
        if(restockAmount <= 0) {
            return "Cannot set 0 or negative numbers.";
        }
        productQuantity += restockAmount;
        return "Successfully restocked: " + productName;
    }
    void displayProduct() {
        System.out.println("Product name: " + productName);
        System.out.println("Price: " + productPrice);
        System.out.println("Stock: " + productQuantity);
    }

    String getProductName() {
        return productName;
    }
    double getProductPrice() {
        return productPrice;
    }
    int getProductQuantity() {
        return productQuantity;
    }
}