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
            employees.add(new Employee(employeeID, employeeName, department, position, hourlyRate, hoursWorks, overtimeHours));
        }
        load.close();
    }
    void savePayroll(ArrayList<Payroll> payrolls) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("records.csv"));
            for(Payroll payroll : payrolls) {
                save.write(payroll.getEmployeeID()
                + "," + payroll.getPayrollID()
                + "," + payroll.getBasicSalary()
                + "," + payroll.getOvertimePay() 
                + "," + payroll.getGrossPay()
                + "," + payroll.getTaxDeduction()
                + "," + payroll.getSSSDeduction() 
                + "," + payroll.getPhilHealth() 
                + "," + payroll.getPagIbigDeduction() 
                + "," + payroll.getTotalDeduction() 
                + "," + payroll.getFinalNetPay());
                save.newLine();
            }
        save.close();
    }
    void loadPayroll(ArrayList<Employee> employees,ArrayList<Payroll> payrolls) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("records.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] loadPayroll = line.split(",");
            int employeeID = Integer.parseInt(loadPayroll[0]);
            int payrollID = Integer.parseInt(loadPayroll[1]);
            double basicSalary = Double.parseDouble(loadPayroll[2]);
            double overtimePay = Double.parseDouble(loadPayroll[3]);
            double grossPay = Double.parseDouble(loadPayroll[4]);
            double taxDeduction = Double.parseDouble(loadPayroll[5]);
            double sssDeduction = Double.parseDouble(loadPayroll[6]);
            double philHealthDeduction = Double.parseDouble(loadPayroll[7]);
            double pagIbigDeduction = Double.parseDouble(loadPayroll[8]);
            double totalDeduction = Double.parseDouble(loadPayroll[9]);
            double finalSalary = Double.parseDouble(loadPayroll[10]);
            Employee targetEmployee = null;

            for(Employee employee : employees) {
                if(employee.getEmployeeID() == employeeID) {
                    targetEmployee = employee;
                    break;
                }
            }

            if(targetEmployee != null) {
                Payroll newPayroll = new Payroll(
                    targetEmployee, 
                    payrollID, 
                    basicSalary, 
                    overtimePay, 
                    taxDeduction, 
                    sssDeduction, 
                    philHealthDeduction, 
                    pagIbigDeduction, 
                    totalDeduction, 
                    grossPay, 
                    finalSalary);

                    payrolls.add(newPayroll);
            }
        }
        load.close();
    }
}