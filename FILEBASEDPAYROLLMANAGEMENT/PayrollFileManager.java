package FILEBASEDPAYROLLMANAGEMENT;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

class FileManager {
    void saveEmployees(ArrayList<Employee> employees) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("employee.csv"));
        for(Employee employee : employees) {
            save.write(employee.getEmployeeID() 
            + "," + employee.getEmployeeName() 
            + "," + employee.getDepartment() 
            + "," + employee.getPosition() 
            + "," + employee.getHourlyRate() 
            + "," + employee.getHoursWorked() 
            + "," + employee.getOvertimeHours());
            save.newLine();
        }
        save.close();
    }
    void loadEmployees(ArrayList<Employee> employees) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("employee.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] employeeData = line.split(",");
            int employeeID = Integer.parseInt(employeeData[0]);
            String employeeName = employeeData[1];
            String department = employeeData[2];
            String position = employeeData[3];
            double hourlyRate = Double.parseDouble(employeeData[4]);
            int hoursWorks = Integer.parseInt(employeeData[5]);
            int overtimeHours = Integer.parseInt(employeeData[6]);
            employees.add( new Employee(employeeID, employeeName, department, position, hourlyRate, hoursWorks, overtimeHours));
        }
        load.close();
    }
    void savePayroll() {

    }
    void loadPayroll() {

    }
}