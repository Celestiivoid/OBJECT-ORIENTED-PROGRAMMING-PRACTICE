package PAYROLLMANAGEMENT;

public class Employee {
    private String employeeName;
    private String position;
    private double basicSalary;
    private int hoursWorked;
    private double grossSalary;
    private boolean isProcessed;
    private boolean isPaid;
    private double afterTax;
    private double taxRate = 0.10;
    private final int REGULAR_HOURS = 160;

    Employee(String employeeName, String position, double basicSalary, int hoursWorked) {
        this.employeeName = employeeName;
        this.position = position;
        this.basicSalary = basicSalary;
        this.hoursWorked = hoursWorked;
        this.grossSalary = 0;
        this.isProcessed = false;
        this.isPaid = false;
    }

    String processSalary() {
        final double HOURLY_RATE = basicSalary / REGULAR_HOURS;
        final double OVERTIME_HOURS = hoursWorked - REGULAR_HOURS;
        final double OVERTIME_PAY = HOURLY_RATE * OVERTIME_HOURS * 1.5;
        if(hoursWorked <= REGULAR_HOURS) {
            grossSalary += basicSalary;
        }
        if(hoursWorked > REGULAR_HOURS) {
            grossSalary += OVERTIME_PAY + basicSalary;
        }
        afterTax += basicSalary - basicSalary * taxRate;
        isProcessed = true;
        isPaid = true;
        return "Sucessfully processed employee.";
    }

    void displayPaySlip() {
        final double OVERTIME_HOURS_DISPLAY = hoursWorked - REGULAR_HOURS;
        final double TAX = basicSalary * taxRate;
        final double GROSS = grossSalary - basicSalary;
        final double TOTAL = basicSalary + GROSS;
        final double GROSS_AFTER_TAX = GROSS - basicSalary * taxRate;

        System.out.println("Employees' name: " + getEmployeeName());
        System.out.println("Position: " + getPosition());
        System.out.println("Hours worked: " + getHoursWorked());
        System.out.println("Overtime hours: " + OVERTIME_HOURS_DISPLAY);
        System.out.println("Salary without gross: " + basicSalary);
        System.out.println("Gross amount: " + GROSS);
        System.out.println("Tax: " + TAX);
        System.out.println("Gross total after tax credit: " + GROSS_AFTER_TAX);
        System.out.println("Total after tax credit: " + afterTax);
        System.out.println("Overall total with gross: " + TOTAL);
        System.out.println("Status: " + getIsPaid());
    }

    String getEmployeeName() {
        return employeeName;
    }
    String getPosition() {
        return position;
    }
    double getBasicSalary() {
        return basicSalary;
    }
    double getHoursWorked() {
        return hoursWorked;
    }
    String getIsProcessed() {
        if(isProcessed) {
            return "Yes";
        }
        return "No";
    }
    String getIsPaid() {
        if(isPaid) {
            return "Paid";
        }
        return "Not-paid";
    }
}
