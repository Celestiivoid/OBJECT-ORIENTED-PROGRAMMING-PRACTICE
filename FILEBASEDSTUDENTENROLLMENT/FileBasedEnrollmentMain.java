package FILEBASEDSTUDENTENROLLMENT;
import java.io.IOException;
import java.util.Scanner;

public class FileBasedEnrollmentMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        EnrollmentService service = new EnrollmentService();
        FileManager manager = new FileManager();
        while(true) {
            System.out.println("=====STUDENT-ENROLLMENT-SYSTEM=====");
            System.out.println("[1] Add Student");
            System.out.println("[2] Add Course");
            System.out.println("[3] View Students");
            System.out.println("[4] View Courses");
            System.out.println("[5] Enroll Student");
            System.out.println("[6] Drop Course");
            System.out.println("[7] View Student's Course");
            System.out.println("[8] View Course's Students");
            System.out.println("[9] Search Student");
            System.out.println("[10] Search Course");
            System.out.println("[11] Save Data");
            System.out.println("[12] Load Data");
            System.out.println("[0] Exit");
            System.out.println("\nEnter option:");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 13) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 0 -> {
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
                case 1 -> service.addStudent();
                case 2 -> service.addCourse();
                case 3 -> service.viewStudents();
                case 4 -> service.viewCourses();
                case 5 -> service.enrollStudent();
                case 6 -> service.dropCourse();
                case 7 -> service.viewStudentCourse();
                case 8 -> service.viewCourseStudent();
                case 9 -> service.searchStudent();
                case 10 -> service.searchCourse();
                case 11 -> manager.saveStudents(EnrollmentService.student);
                case 12 -> manager.loadStudents(EnrollmentService.student);
            }


        }
    }
}
