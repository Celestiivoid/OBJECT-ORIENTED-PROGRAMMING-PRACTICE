package SIMPLEBANK;
import java.util.Scanner;

public class SimpleBank {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BankAccount bankacc = new BankAccount("Josh");
        while(true) {
            System.out.println("=====BANK-ACCOUNT-SYSTEM=====");
            System.out.println("[1] Deposit");
            System.out.println("[2] Withdraw");
            System.out.println("[3] View Account");
            System.out.println("[4] Exit");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 4) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> bankacc.deposit();
                case 2 -> bankacc.withdraw();
                case 3 -> bankacc.displayAccount();
                case 4 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String exit = scanner.nextLine();

                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }
}
