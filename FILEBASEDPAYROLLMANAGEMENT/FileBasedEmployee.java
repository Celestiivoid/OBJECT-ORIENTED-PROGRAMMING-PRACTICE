package FILEBASEDPAYROLLMANAGEMENT;
class Employee {
    private int employeeID;
    private String employeeName;
    private String department;
    private String position;
    private double hourlyRate;
    private int hoursWorked;
    private int overtimeHours;
    private double basicSalary;
    private double overtimePay;
    private double deduction;
    private double netSalary;

    Employee(int employeeID, 
        String employeeName, String department, 
        String position, double hourlyRate, 
        int hoursWorked, int overtimeHours) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours; 
    }
    double calculateBasicSalary() {
        basicSalary = hourlyRate * hoursWorked;
        return basicSalary;
    }
    double calculateOvertime() {
        overtimePay = hourlyRate * overtimeHours;
        return overtimePay;
    }
    double calculateNetSalary() {
        netSalary = basicSalary + overtimePay;
        return netSalary;
    }
    void displayEmployee() {
    }

    int getEmployeeID() {
        return employeeID;
    }
    String getEmployeeName() {
        return employeeName;
    }
    String getDepartment() {
        return department;
    }
    String getPosition() {
        return position;
    }
    double getHourlyRate() {
        return hourlyRate;
    }
    int getHoursWorked() {
        return hoursWorked;
    }
    int getOvertimeHours() {
        return overtimeHours;
    }
}