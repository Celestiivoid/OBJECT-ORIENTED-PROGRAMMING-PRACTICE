package SIMPLEBANK;
import java.util.Scanner;
import java.util.ArrayList;

class BankService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccount> bankAcc = new ArrayList<>();
    private double handsOnMoney = 500;

    void userRegistration() {
        while(true) {
            System.out.println("=====USER-REGISTRATION=====");
            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < bankAcc.size(); i++) {
                BankAccount display = bankAcc.get(i);
                if(name.equalsIgnoreCase(display.getName())) {
                    System.out.println("Account already exist.");
                    return;
                }
            }

            System.out.println("Enter initial deposit: ");
            double initialDeposit;

            try {
                initialDeposit = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(initialDeposit <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            BankAccount bankAccount = new BankAccount(name,initialDeposit);
            bankAcc.add(bankAccount);
            System.out.println("Registered successfully.");
            return;
        }
    }
    void deposit() {
        double depositTotal = 0;
        while(true) {
            System.out.println("=====DEPOSIT-MENU=====");
            System.out.println("Money on-hand: " + handsOnMoney);
            System.out.println("Enter amount to deposit: ");
            double deposit;

            try {
                deposit = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }
            if(deposit > handsOnMoney) {
                System.out.println("Cannot deposit more than you own.");
                continue;
            }
            for(int i = 0; i < bankAcc.size(); i++) {
                BankAccount dp = bankAcc.get(i);
                depositTotal = deposit;
                dp.depositRule(deposit);
                handsOnMoney -= depositTotal;
            }
            System.out.println("Successfully deposited: " + depositTotal);
            return;
        }
    }
    void withdraw() {
        while(true) {
            double withdrawTotal = 0;
            System.out.println("=====WITHDRAW-MENU=====");
            System.out.println("Money on-hand: " + handsOnMoney);
            System.out.println("Enter amount to withdraw: ");
            double withdraw;

            try {
                withdraw = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            for(int i = 0; i < bankAcc.size(); i++) {
                BankAccount wd = bankAcc.get(i);
                withdrawTotal = withdraw;
                wd.withdrawRule(withdraw);
                withdraw -= wd.getBalance();
                handsOnMoney += withdrawTotal;
            }
            System.out.println("Successfully withdrew: " + withdrawTotal);
            return;
        }
    }
    void displayAccount() {
        if(bankAcc.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for(int i = 0; i < bankAcc.size(); i++) {
            BankAccount display = bankAcc.get(i);
            System.out.println((i + 1) + ".) " 
            + "Name: " + display.getName() 
            + " | Balance: " + display.getBalance());
        } 
    }
    void transfer() {
        while(true) {
            double transferTotal = 0;
            System.out.println("=====TRANSFER-MONEY-MENU=====");

            if(bankAcc.isEmpty()) {
                displayAccount();
                return;
            }
            displayAccount();

            System.out.println("Pick a user to transfer money: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick > bankAcc.size()) {
                System.out.println("Out of range.");
                continue;
            }

            System.out.println("Enter amount to transfer: ");
            double transfer;

            try {
                transfer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            BankAccount selectedAccount = bankAcc.get(pick - 1);

            for(int i = 0; i < bankAcc.size(); i++) {
                transferTotal = transfer;
                BankAccount ts = bankAcc.get(i);
                selectedAccount.transferRule(transfer);
                transfer += ts.getBalance();
            }
            System.out.println("Successfully transferred: " + transferTotal);
        }
    }
}
