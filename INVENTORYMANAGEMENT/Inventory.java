package INVENTORYMANAGEMENT;

class Inventory {
    String productName;
    double productPrice;
    int productQuantity;
    
    Inventory(String productName, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    String addProductRule(double pPrice, int pQuantity) {
        if(pPrice <= 0.0) {
            return "Cannot set 0 or negative numbers.";
        }
        return "Successfully added product to inventory.";
    }
    String getProductName() {
        return productName;
    }
    double getProductPrice() {
        return productPrice;
    }
    int getProductQuantity() {
        return  productQuantity;
    }
}
