package SIMPLEBANK;
import java.util.Scanner;
class BankAccount {
    private String ownerName;
    private double balance;
    private double onHandMoney;
    static Scanner scanner = new Scanner(System.in);

    BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.onHandMoney = 500;
        this.balance = 5000;
    }

    void deposit() {
        while(true) {
            System.out.println("====DEPOSIT-MENU=====");
            System.out.println("Enter amount to deposit: ");
            
            double depositMoney;

            try {
                depositMoney = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(depositMoney <= 0.0) {
                System.out.println("Deposit cannot be 0 or negative numbers.");
                continue;
            }
            if(depositMoney > onHandMoney) {
                System.out.println("Cannot deposit more than you own.");
                continue;
            }
            balance += depositMoney;
            onHandMoney -= depositMoney;
            System.out.println("Successfully deposited: " + depositMoney);
            return;
        }
    }
    void withdraw() {
        while(true) {
            System.out.println("=====WITHDRAW-MENU=====");
            System.out.println("Enter amount to withdraw: ");

            double withdrawMoney;

            try {
                withdrawMoney = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(withdrawMoney <= 0.0) {
                System.out.println("Withdraw cannot be 0 or negative numbers.");
                continue;
            }
            if(withdrawMoney > balance) {
                System.out.println("Insufficient balance.");
                continue;
            }
            onHandMoney += withdrawMoney;
            balance -= withdrawMoney;
            System.out.println("Successfully withdrew: " + withdrawMoney);
            return;
        }
    }
    void displayAccount() {
        System.out.println("Name: " + ownerName);
        System.out.println("Bank Balance: " + balance);
        System.out.println("On-hand Money: " + onHandMoney);
    }
}