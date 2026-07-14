package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class EnrollmentService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> student = new ArrayList<>();
    static ArrayList<Course> course = new ArrayList<>();
    static Random random = new Random();

    void addStudent() {
        while(true) { 
            int studentID = random.nextInt(1000, 9999);
            System.out.println("=====ADD-STUDENT=====");
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < student.size(); i++) {
                Student auth = student.get(i);
                if(name.equals(auth.getStudentName())) {
                    System.out.println("Student already exist.");
                    return;
                }
            }
            Student addStudent = new Student(studentID, name);
            student.add(addStudent);
            System.out.println("Successfully added student.");
            return;
        }
    }
    void addCourse() {
        while(true) {
            System.out.println("=====ADD-COURSE=====");
            System.out.println("Enter course name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Course field cannot be empty.");
                continue;
            }

            for(int i = 0; i < student.size(); i++) {
                Student auth = student.get(i);
                if(name.equals(auth.getStudentName())) {
                    System.out.println("Subject already exist.");
                    return;
                }
            }

            System.out.println("Enter course code: ");
            int code;

            try {
                code = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(code < 100 || code > 999) {
                System.out.println("3 Digits only.");
            }

            System.out.println("Enter max slots: ");
            int max;

            try {
                max = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(max <= 0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            Course newCourse = new Course(code, name, max);
            course.add(newCourse);
            System.out.println("Successfully added course!");
            return;
        }
    }
    void viewStudents() {

    }
    void viewCourses() {

    }
    void enrollStudent() {

    }
    void dropCourse() {

    }
    void viewStudentCourse() {

    }
    void viewCourseStudent() {

    }
    void searchStudent() {

    }
    void searchCourse() {

    }
}
