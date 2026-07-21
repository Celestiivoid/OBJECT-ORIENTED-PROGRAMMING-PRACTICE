package FILEBASEDPAYROLLMANAGEMENT;
class Employee {
    private int employeeID;
    private String employeeName;
    private String department;
    private String position;
    private double hourlyRate;
    private int hoursWorked;
    private int overtimeHours;

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
        return hourlyRate * hoursWorked;
    }
    double calculateOvertime() {
        return hourlyRate * overtimeHours * 1.25;
    }
    void displayEmployee() {
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Employees' name: " + getEmployeeName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Position: " + getPosition());
        System.out.println("Hourly rate: " + getHourlyRate());
        System.out.println("Hours worked: " + getHoursWorked());
        System.out.println("Overtime hours: " + getOvertimeHours());
    }

    //setters
    void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    void setDepartment(String department) {
        this.department = department;
    }
    void setPosition(String position) {
        this.position = position;
    }
    void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    //getters
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