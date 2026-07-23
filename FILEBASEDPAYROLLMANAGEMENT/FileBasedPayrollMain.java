package FILEBASEDPAYROLLMANAGEMENT;
import java.io.IOException;
import java.util.Scanner;
public class FileBasedPayrollMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        FileBasedService service = new FileBasedService();
        FileManager manager = new FileManager();
        while(true) {
            System.out.println("=====PAYROLL-MANAGEMENT-SYSTEM=====");
            System.out.println("[1] Add Employee");
            System.out.println("[2] View Employees");
            System.out.println("[3] Search Employee");
            System.out.println("[4] Update Employee");
            System.out.println("[5] Remove Employee");
            System.out.println("[6] Process Payroll");
            System.out.println("[7] View Payroll");
            System.out.println("[8] View Employee Payslip");
            System.out.println("\n[9] Save Data");
            System.out.println("[10] Load Data");
            System.out.println("[0] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 10) {
                System.out.println("Out of range!");
                continue;
            }
            
            switch(option) {
                case 1 -> service.addEmployee();
                case 2 -> service.viewEmployees();
                case 3 -> service.searchEmployee();
                case 4 -> service.updateEmployee();
                case 5 -> service.removeEmployee();
                case 6 -> service.processPayroll();
                case 7 -> service.viewPayroll();
                case 8 -> service.viewPayslip();
                case 9 -> {
                    manager.saveEmployees(FileBasedService.employee);
                    manager.savePayroll(FileBasedService.payroll);
                    System.out.println("Data saved succesfully.");
                }
                case 10 -> {
                    manager.loadEmployees(FileBasedService.employee);
                    manager.loadPayroll(FileBasedService.employee, FileBasedService.payroll);
                    System.out.println("Data loaded successfully.");
                }
            }
        }
    }
}
