package FILEBASEDPAYROLLMANAGEMENT;

import java.util.ArrayList;

class Payroll {
    static ArrayList<Payroll> record = new ArrayList<>();
    private int payrollID;
    private Employee employee;
    private double basicPay;
    private double overtimePay;
    private double taxDeduction;
    private double sssDeduction;
    private double philHealthDeduction; 
    private double pagIbigDeduction;
    private double totalDeduction;
    private double grossPay;
    private double finalNetPay;

    Payroll(Employee employee, int payrollID) {
        this.employee = employee;
        this.payrollID = payrollID;
    }
    Payroll(Employee employee,
            int payrollID,
            double basicPay,
            double overtimePay,
            double taxDeduction,
            double sssDeduction,
            double philHealthDeduction,
            double pagIbigDeduction,
            double totalDeduction,
            double grossPay,
            double finalNetPay) {

        this.employee = employee;
        this.payrollID = payrollID;
        this.basicPay = basicPay;
        this.overtimePay = overtimePay;
        this.taxDeduction = taxDeduction;
        this.sssDeduction = sssDeduction;
        this.philHealthDeduction = philHealthDeduction;
        this.pagIbigDeduction = pagIbigDeduction;
        this.totalDeduction = totalDeduction;
        this.grossPay = grossPay;
        this.finalNetPay = finalNetPay;
    }
    String computePayroll() {
        basicPay = employee.calculateBasicSalary();
        overtimePay = employee.calculateOvertime();
        grossPay = basicPay + overtimePay;
        taxDeduction =  grossPay * 0.10;
        sssDeduction = grossPay * 0.05;
        philHealthDeduction = grossPay * 0.08;
        pagIbigDeduction = grossPay * 0.12;
        totalDeduction = taxDeduction + sssDeduction + philHealthDeduction + pagIbigDeduction;
        finalNetPay = grossPay - totalDeduction;

        return "Successfully processed: " + employee.getEmployeeName();
    }
    void displayPayroll() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Employee name: " + getEmployeeName());
        System.out.println("Basic pay: " + basicPay);
        System.out.println("Overtime pay: " + overtimePay);
    }
    void displayPayslip() {
        System.out.println("============PAY-SLIP============");
        System.out.println("Payroll ID: " + payrollID);
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Employee name: " + getEmployeeName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Position: " + getPosition());
        System.out.println("\n==============================");
        System.out.println("\nBasic salary: " + basicPay);
        System.out.println("Overtime pay: " + overtimePay);
        System.out.println("Partial salary before deduction: " + grossPay);
        System.out.println("\n==========DEDUCTIONS==========");
        System.out.println("\nTax: " + taxDeduction);
        System.out.println("SSS: " + sssDeduction);
        System.out.println("Phil health: " + philHealthDeduction);
        System.out.println("Pag-ibig: " + pagIbigDeduction);
        System.out.println("\n------------------------------");
        System.out.println("\n Net pay: " + finalNetPay);
        System.out.println("\n==============================");
    }

    int getPayrollID() {
        return payrollID;
    }
    int getEmployeeID() {
        return employee.getEmployeeID();
    }
    String getEmployeeName() {
        return employee.getEmployeeName();
    }
    String getDepartment() {
        return employee.getDepartment();
    }
    String getPosition() {
        return employee.getPosition();
    }
    double getBasicSalary() {
        return basicPay;
    }
    double getOvertimePay() {
        return overtimePay;
    }
    double getGrossPay() {
        return grossPay;
    }
    double getTaxDeduction() {
        return taxDeduction;
    }
    double getSSSDeduction() {
        return sssDeduction;
    }
    double getPhilHealth() {
        return philHealthDeduction;
    }
    double getPagIbigDeduction() {
        return pagIbigDeduction;
    }
    double getFinalNetPay() {
        return finalNetPay;
    }
    double getTotalDeduction() {
        return totalDeduction;
    }

    ArrayList<Payroll> getRecords() {
        return record;
    }
}