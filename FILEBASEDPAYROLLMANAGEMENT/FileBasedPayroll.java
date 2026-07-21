package FILEBASEDPAYROLLMANAGEMENT;
class Payroll {
    private Employee employee;
    private double basicPay;
    private double overtimePay;
    private double taxDeducation;
    private double sssDeducation;
    private double philHealthDeduction; 
    private double pagIbigDeducation;
    private double totalDeduction;
    private double netPay;

    Payroll(Employee employee) {
        this.employee = employee;
    }
    String computePayroll() {
        basicPay = employee.calculateBasicSalary();
        overtimePay = employee.calculateOvertime();
        netPay = basicPay + overtimePay;

        return "Successfully processed: " + employee.getEmployeeName();
    }
    void displayPayroll() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Bsaic salary: " + basicPay);
    }
    void displayPayslip() {
    }

    int getEmployeeID() {
        return employee.getEmployeeID();
    }
}