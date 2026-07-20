package FILEBASEDPAYROLLMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class FileBasedService {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employee = new ArrayList<>();
    static ArrayList<Payroll> payroll = new ArrayList<>();
    static int employeeID = random.nextInt(1001,9999);
    
    void addEmployee() {
        while(true) {
            System.out.println("=====ADD-EMPLOYEE=====");
            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            System.out.println("Enter department: ");
            String department = scanner.nextLine();

            if(department.isEmpty()) {
                System.out.println("Department field cannot be empty.");
                continue;
            }

            System.out.println("Enter position: ");
            String position = scanner.nextLine();

            if(position.isEmpty()) {
                System.out.println("Position field cannot be empty.");
                continue;
            }

            System.out.println("Enter hourly rate: ");
            double hourlyRate;

            try {
                hourlyRate = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(hourlyRate <= 0.0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            System.out.println("Enter hours worked: ");
            int hoursWork;

            try {
                hoursWork = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(hoursWork <= 0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            System.out.println("Enter overtime hours: ");
            int overtimeHours;

            try {
                overtimeHours = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(overtimeHours <= 0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }
            Employee newEmployee = new Employee(employeeID, name, 
                department, position, 
                hourlyRate, hoursWork, 
                overtimeHours);
            employee.add(newEmployee);
            System.out.println("Successfully added employee!");
            return;
        }
    }
    void viewEmployees() {
            System.out.println("=====VIEW-EMPLOYEE=====");
            if(employee.isEmpty()) {
                System.out.println("No Available employee.");
                return;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee view = employee.get(i);
                System.out.println((i + 1) + ".) " 
                + "Employee ID: " + view.getEmployeeID() 
                + "\n | Employee name: " + view.getEmployeeName() 
                + "\n | Position: " + view.getPosition() 
                + "\n | Basic salary: " + view.calculateBasicSalary() 
                + "\n | Overtime pay: " + view.calculateOvertime() 
                + "\n | Net salary: " + view.calculateNetSalary());
            }
    }
    void forUpdateEmployee() {
        if(employee.isEmpty()) {
                System.out.println("No Available employee.");
                return;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee view = employee.get(i);
                System.out.println((i + 1) + ".) " 
                + "Employee ID: " + view.getEmployeeID() 
                + " | Employee name: " + view.getEmployeeName() 
                + " | Position: " + view.getPosition());
            }
    }
    void forRemoveEmployee() {
        if(employee.isEmpty()) {
                System.out.println("No Available employee.");
                return;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee view = employee.get(i);
                System.out.println((i + 1) + ".) " 
                + "Employee ID: " + view.getEmployeeID() 
                + " | Employee name: " + view.getEmployeeName() 
                + " | Position: " + view.getPosition());
            }
    }
    void forProcessEmployee() {
        if(employee.isEmpty()) {
                System.out.println("No Available employee.");
                return;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee view = employee.get(i);
                System.out.println((i + 1) + ".) " 
                + "Employee ID: " + view.getEmployeeID() 
                + " | Employee name: " + view.getEmployeeName() 
                + " | Position: " + view.getPosition());
            }
    }
    void forViewProcessedPayrol(Payroll payroll) {

    }
    void searchEmployee() {
        while(true) {
            int incrementation = 1;
            System.out.println("=====SEARCH-EMPLOYEE=====");
            System.out.println("Enter employee name or position: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < employee.size(); i++) {
                Employee search = employee.get(i);
                if(name.equals(search.getEmployeeName()) || name.equals(search.getPosition()) ) {
                    System.out.println((incrementation + ".) " + " | Name: " + search.getEmployeeName() + " | Position: " + search.getPosition()));
                    incrementation++;
                }
            }
        }
    }
    void updateEmployee() {
        while(true) {
            System.out.println("=====UPDATE-EMPLOYEEE=====");

            if(employee.isEmpty()) {
                forUpdateEmployee();
                return;
            }
            forUpdateEmployee();
            System.out.println("Select an employee to update: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > employee.size()) {
                System.out.println("Out of range!");
                return;
            }
            else {
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();

                if(newName.isEmpty()) {
                    System.out.println("Name field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new department: ");
                String newDepartment = scanner.nextLine();

                if(newDepartment.isEmpty()) {
                    System.out.println("Department field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new position: ");
                String newProgrammer = scanner.nextLine();

                if(newProgrammer.isEmpty()) {
                    System.out.println("Position field cannot be empty.");
                    continue;
                }

                System.out.println("Enter new hourly rate: ");
                double newHourlyRate;

                try {
                    newHourlyRate = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only.");
                    continue;
                }

                if(newHourlyRate <= 0.0) {
                    System.out.println("Cannot validate 0 or negative numbers.");
                    continue;
                }

                System.out.println("Enter new hours worked: ");
                int newHoursWorked;

                try {
                    newHoursWorked = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only.");
                    continue;
                }

                if(newHoursWorked <= 0) {
                    System.out.println("Cannot validate 0 or negative numbers.");
                    continue;
                }

                System.out.println("Enter new overtime hours: ");
                int newOvertimeHours;

                try {
                    newOvertimeHours = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Numbers only.");
                    continue;
                }

                if(newOvertimeHours <= 0) {
                    System.out.println("Cannot validate 0 or negative numbers.");
                    continue;
                }

                Employee updateEmployee = new Employee(employeeID, newName, 
                    newDepartment, newProgrammer, 
                    newHourlyRate, newHoursWorked, 
                    newOvertimeHours);

                    employee.set(option - 1, updateEmployee);
                    System.out.println("Successfully updated employee.");
                    return;
            }
        }
    }
    void removeEmployee() {
        while(true) {
            System.out.println("=====REMOVE-EMPLOYEE=====");
            if(employee.isEmpty()) {
                forRemoveEmployee();
                return;
            }
            forRemoveEmployee();
            System.out.println("Pick an employee to remove: ");
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
            else {
                employee.remove(option - 1);
                System.out.println("Successfully removed employee.");
                return;
            }
        }
    }
    void processPayroll() {
        while(true) {
            System.out.println("=====PROCESS-PAYROLL=====");
            if(employee.isEmpty()) {
                forProcessEmployee();
                return;
            }
            forProcessEmployee();
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
            Employee selectedEmployee = employee.get(option - 1);
            Payroll processedPayroll = new Payroll();
            String result = processedPayroll.computePayroll(selectedEmployee);
            System.out.println(result);
            return;
        }
    }
    void viewPayroll() {
        if(payroll.isEmpty()) {
            System.out.println("No processed employee.");
            return;
        }
        for(int i = 0; i < payroll.size(); i++) {
            Payroll view = payroll.get(i);
            System.out.println("Employee name: " + view.getEmployeeName());
        }
    }
    void viewPayslip() {

    }
    void calculateSalary() {

    }
    void calculateOvertime() {

    }
    void calculateDeduction() {

    }
}
