package PAYROLLMANAGEMENT;
import java.util.Scanner;

public class PayrollMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PayrollService service = new PayrollService();
        while(true) {
            System.out.println("=====PAYROLL-SYSTEM=====");
            System.out.println("[1] Add Employee");
            System.out.println("[2] View Employees");
            System.out.println("[3] Process Salary");
            System.out.println("[4] View PaySlip");
            System.out.println("[5] Search Employee");
            System.out.println("[6] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 7) {
                System.out.println("Out of range!");
                continue;
            }

            switch(option) {
                case 1 -> service.addEmployee();
                case 2 -> service.viewEmployees();
                case 3 -> service.processSalary();
                case 4 -> service.viewPaySLip();
                case 5 -> service.searchEmployee();
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
