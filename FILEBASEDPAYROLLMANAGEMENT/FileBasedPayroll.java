package FILEBASEDPAYROLLMANAGEMENT;
import java.util.ArrayList;
import java.util.Random;
class Payroll {
    static Random random = new Random();
    static ArrayList<Employee> processedEmployee = new ArrayList<>();
    static private int payrollID = random.nextInt(1000,9999);
    private String employeeName;
    private double basicPay;
    private double overtimePay;
    private double taxDeducation;
    private double sssDeducation;
    private double philHealthDeduction; 
    private double pagIbigDeducation;
    private double totalDeduction;
    private double netPay;

    String computePayroll(Employee employees) {
        employeeName = employees.getEmployeeName();
        basicPay = employees.calculateBasicSalary();
        overtimePay = employees.calculateOvertime();
        netPay = employees.calculateNetSalary();
        if(processedEmployee.contains(employees)) {
            return employees.getEmployeeName() + " is already processed.";
        }

        processedEmployee.add(employees);
        return "Successfully processed: " + employees.getEmployeeName();
    }
    void displayPayroll() {
        System.out.println("Employee name: " + getEmployeeName());
        System.out.println("Basic pay: " + getBasicPay());
    }
    void displayPayslip() {

    }

    String getEmployeeName() {
        return employeeName;
    }
    double getBasicPay() {
        return basicPay;
    }
}