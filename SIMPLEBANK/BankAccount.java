package SIMPLEBANK;
import java.util.Scanner;
class BankAccount {
    private String ownerName;
    private double balance;
    static Scanner scanner = new Scanner(System.in);

    BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    String depositRule(double depositMoney) {
        if(depositMoney <= 0.0) {
            return "Deposit cannot be 0 or negative numbers.";
        }
        balance += depositMoney;
        return "Successfully deposited: " + depositMoney;
    }

    String withdrawRule(double withdrawMoney) {
        if(withdrawMoney <= 0.0) {
            return "Withdraw cannot be 0 or negative numbers.";
        }
        if(withdrawMoney > balance) {
            return "Insufficient balance." ;
        }

        balance -= withdrawMoney;
        return "Successfully withdrew: " + withdrawMoney;
    }

    String transferRule(double transferMoney) {
        if(transferMoney <= 0.0) {
            return "Transfer cannot be 0 or negative numbers.";
        }
        if(transferMoney > balance) {
            return "Cannot transfer more than you own.";
        }
        balance -= transferMoney;
        return "Successfully transferred: " + transferMoney;
    }

    String getName() {
        return ownerName;
    }
    double getBalance() {
        return balance;
    }
}