package PAYROLLMANAGEMENT;

 public class Employee {
    private String employeeName;
    private String position;
    private double basicSalary;
    private int hoursWorked;
    private double grossSalary;
    private boolean isProcessed;
    private boolean isPaid;
    private final double TAX_RATE = 0.10;
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
        if(isProcessed && isPaid) {
            return "Payment already processed for " + getEmployeeName(); 
        }
        if(hoursWorked <= REGULAR_HOURS) {
            grossSalary = basicSalary;
        }
        if(hoursWorked > REGULAR_HOURS) {
            grossSalary = OVERTIME_PAY + basicSalary;
        }
        isProcessed = true;
        isPaid = true;
        return "Sucessfully processed employee.";
    }

    void displayPaySlip() {
        double OVERTIME_HOURS_DISPLAY = hoursWorked - REGULAR_HOURS;
        double GROSS = grossSalary - basicSalary;
        final double TAX = basicSalary * TAX_RATE;
        double GROSS_TAX = GROSS * TAX_RATE;
        final double TOTAL_TAX = TAX + GROSS_TAX;
        double TOTAL = basicSalary + GROSS;
        double AFTER_TAX = TOTAL - TOTAL_TAX;


        System.out.println("Employees' name: " + getEmployeeName());
        System.out.println("Position: " + getPosition());
        System.out.println("Hours worked: " + getHoursWorked());
        if(hoursWorked <= REGULAR_HOURS) {
            OVERTIME_HOURS_DISPLAY = 0.0;
            System.out.println("Overtime hours: " + OVERTIME_HOURS_DISPLAY);
        }
        else {
            System.out.println("Overtime hours: " + OVERTIME_HOURS_DISPLAY);
        }
        System.out.println("Salary without gross: " + basicSalary);
        System.out.println("Salary tax: " + TAX);
        if(isProcessed == false && isPaid == false) {
            GROSS_TAX = 0;
            AFTER_TAX = 0;
            GROSS = 0;
            TOTAL = 0;
            String result = " (Not yet processed.)";
            System.out.println("Gross amount: " + GROSS + result);
            System.out.println("Gross tax: " + GROSS_TAX + result);
            System.out.println("Overall total with gross: " + TOTAL + result);
            System.out.println("Total after tax: " + AFTER_TAX + result);
        }
        else {
            System.out.println("Gross amount: " + GROSS);
            System.out.println("Gross tax: " + GROSS_TAX);
            System.out.println("Overall total with gross: " + TOTAL);
            System.out.println("Total tax: " + TOTAL_TAX);
            System.out.println("Total after tax: " + AFTER_TAX);
        }
        System.out.println("Processed: " + getIsProcessed());
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
