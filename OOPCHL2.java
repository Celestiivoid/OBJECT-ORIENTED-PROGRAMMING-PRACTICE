class Manager extends Accounts {
    private int balance; // Avoid data manipulation and prevents objects from altering it outside the class
    
    void deposit(int amount) {
        balance += amount;
        if(amount <= balance) { //Validations for sending data back to balance field.
            balance -= amount;
        }
    }
}

public class OOPCHL2 {
    public static void main(String[] args) {
    }
    
}
