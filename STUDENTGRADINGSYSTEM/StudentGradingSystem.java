package STUDENTGRADINGSYSTEM;
import java.util.Scanner;

public class StudentGradingSystem {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentService service = new StudentService();
        while(true) {
            System.out.println("=====STUDENT-GRADING-SYSTEM=====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View Students");
            System.out.println("[3] Grade Students");
            System.out.println("[4] View Student Report");
            System.out.println("[5] Search Student");
            System.out.println("[6] Exit");
            
            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.addStudent();
                case 2 -> service.viewStudents();
                case 3 -> service.gradeStudents();
                case 4 -> service.viewStudentReport();
                case 5 -> service.searchStudent();
                case 6 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String exit = scanner.nextLine();
                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }
}
