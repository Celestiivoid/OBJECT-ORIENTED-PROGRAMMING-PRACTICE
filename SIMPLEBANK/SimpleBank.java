package SIMPLEBANK;
import java.util.Scanner;

public class SimpleBank {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BankService service = new BankService();
        while(true) {
            System.out.println("=====BANK-ACCOUNT-SYSTEM=====");
            System.out.println("[1] Registration");
            System.out.println("[2] Deposit");
            System.out.println("[3] Withdraw");
            System.out.println("[4] View Account");
            System.out.println("[5] Transfer Money");
            System.out.println("[6] Exit");

            System.out.println("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.userRegistration();
                case 2 -> service.deposit();
                case 3 -> service.withdraw();
                case 4 -> service.displayAccount();
                case 5 -> service.transfer();
                case 6 -> {
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
