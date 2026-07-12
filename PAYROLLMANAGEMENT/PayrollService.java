package PAYROLLMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;

class PayrollService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employee = new ArrayList<>();

    void addEmployee() {
        while(true) {
            System.out.println("=====ADD-EMPLOYEE=====");
            System.out.println("Enter employees' name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }
            
            System.out.println("Enter position: ");
            String position = scanner.nextLine();

            if(position.isEmpty()) {
                System.out.println("Position field cannot be empty.");
                continue;
            }

            System.out.println("Enter salary: ");
            double salary;

            try {
                salary = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(salary <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            System.out.println("Enter hours worked: ");
            int hoursAmt;

            try {
                hoursAmt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(hoursAmt < 0) {
                System.out.println("Cannot validate negative numbers.");
                continue;
            }

            Employee newEmployee = new Employee(name, position, salary, hoursAmt);
            employee.add(newEmployee);
            System.out.println("Sucessfully added employee!");
            return;
        }
    }
    void viewEmployees() {
        System.out.println("=====VIEW-EMPLOYEES=====");
        if(employee.isEmpty()) {
            System.out.println("No available employee/s to show.");
            return;
        }

        for(int i = 0; i < employee.size(); i++) {
            Employee view = employee.get(i);
            System.out.println((i + 1) + ".) " + view.getEmployeeName() 
            + "\n" + "Position: "+ view.getPosition() 
            + "\nSalary: " + view.getBasicSalary() 
            + "\nProcessed: " + view.getIsProcessed()
            + "\nStatus: " + view.getIsPaid());
        }
    }
    void forProcessAndViewSlip() {
        if(employee.isEmpty()) {
            System.out.println("No available employee/s to show.");
            return;
        }

        for(int i = 0; i < employee.size(); i++) {
            Employee pvView = employee.get(i);
            System.out.println((i + 1) + ".) " + pvView.getEmployeeName() 
            + "\n" + "Position: "+ pvView.getPosition() 
            + "\nSalary: " + pvView.getBasicSalary());
        }
    }
    void processSalary() {
        while(true) {
            System.out.println("=====PROCESS-SALARY=====");
            if(employee.isEmpty()) {
            forProcessAndViewSlip();
            return;
            }

            forProcessAndViewSlip();
            System.out.println("Pick an employee to process: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > employee.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Employee selecetedEmployee = employee.get(option - 1);
            String result = selecetedEmployee.processSalary();
            System.out.println(result);
            return;
        }
    }
    void viewPaySLip() {
        while(true) {
            System.out.println("=====VIEW-PAYSLIP=====");
            if(employee.isEmpty()) {
                forProcessAndViewSlip();
            }

            forProcessAndViewSlip();
            System.out.println("Select employee: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > employee.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Employee selectedEmployee = employee.get(option - 1);
            selectedEmployee.displayPaySlip();
            return;
        }
    }
    void searchEmployee() {
        while(true) {
            System.out.println("=====SEARCH-EMPLOYEE=====");
            System.out.println("Search employee: ");
            String searchName = scanner.nextLine();

            if(searchName.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                continue;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee search = employee.get(i);
                if(searchName.equalsIgnoreCase(search.getEmployeeName())) {
                    System.out.println("Employee found.");
                    System.out.println("Employees' name: " + search.getEmployeeName() 
                    + " | Position: " + search.getPosition());
                    return;
                }
            }
        }
    }
}
