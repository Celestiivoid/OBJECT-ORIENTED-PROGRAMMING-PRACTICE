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

            System.out.println("Enter available slots: ");
            int available;

            try {
                available = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(available <= 0) {
                System.out.println("Cannot validate 0 or negative numbers.");
                continue;
            }

            Course newCourse = new Course(code, name, max, available);
            course.add(newCourse);
            System.out.println("Successfully added course!");
            return;
        }
    }

    void viewStudents() {
        if(student.isEmpty()) {
            System.out.println("No available students.");
            return;
        }

        for(int i = 0; i < student.size(); i++) {
            Student view = student.get(i);
            System.out.println(
              "Student name: " + view.getStudentName() 
            + " | Student ID: " + view.getStudentID());
        }
    }
    void viewCourses() {
        if(course.isEmpty()) {
            System.out.println("No available courses.");
            return;
        }
        for(int i = 0; i < course.size(); i++) {
            Course view = course.get(i);
            System.out.println(
              "Course code: " + view.getCourseCode() 
            + " | Course name: " + view.getCourseTitle() 
            + " | Maximum slots: " + view.getMaxSlot() 
            + " | Available slots : " 
            + view.getAvailableSlots());
        }
    }
    void enrollStudent() {
        while(true) {
            System.out.println("=====ENROLL-STUDENT=====");
            if(student.isEmpty()) {
                viewStudents();
                return;
            }

            viewStudents(); 
            System.out.println("Select a student to enroll: ");
            int studentOption;

            try {
                studentOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(studentOption < 1 || studentOption > student.size()) {
                System.out.println("Out of range.");
            }

            Student selectedStudent = student.get(studentOption - 1);

            viewCourses();
            System.out.println("Select a course to enroll: ");
            int courseOption;

            try {
                courseOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(courseOption < 1 || courseOption > course.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Course selectedCourse = course.get(courseOption - 1);
            String result1 = selectedStudent.enrollCourse();
            int result2 = selectedCourse.addStudents();
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(selectedCourse.getAvailableSlots());
            return;
        }
    }
    void dropCourse() {

    }
    void viewStudentCourse() {
        System.out.println("=====VIEW-STUDENTS=====");
        if(student.isEmpty()) {
            viewStudents();
        }

        for(int i = 0; i < student.size(); i++) {
            Student viewS = student.get(i);
            System.out.println("Student name: " + viewS.getStudentName() 
                + " | Student ID: " + viewS.getStudentID());
            System.out.println("Courses: ");
            for(int j = 0; j < course.size(); j++) {
                Course viewC = course.get(j);
                System.out.println((j + 1) + ".) " + viewC.getCourseTitle() 
                + " | Course code: " + viewC.getCourseCode() );
            }
            System.out.println("Status: " + viewS.getIsEnrolled());
        }
    }
    void viewCourseStudent() {

    }
    void searchStudent() {

    }
    void searchCourse() {

    }
}
