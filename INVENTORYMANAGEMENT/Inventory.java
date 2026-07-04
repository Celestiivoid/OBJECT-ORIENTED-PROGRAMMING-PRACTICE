package INVENTORYMANAGEMENT;

class Inventory {
    private String productName;
    private double productPrice;
    private int productQuantity;

    Inventory(String productName, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    void buy() {

    }
    void restock() {

    }
    void displayProduct() {

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