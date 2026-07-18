package FILEBASEDSTUDENTENROLLMENT;
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
                continue;
            }

            Student selectedStudent = student.get(studentOption - 1);

            if(course.isEmpty()) {
                viewCourses();
                return;
            }
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
            
            String result = selectedCourse.addStudents(selectedStudent);

            if(result.equals("Successfully enrolled")) {
                selectedStudent.enrollCourse(selectedCourse);
            }
            System.out.println(result);
            return;
        }
    }

    void dropCourse() {
        while(true) {
            System.out.println("=====DROP-COURSE=====");
            
            if(student.isEmpty()) {
                forDrop();
                return;
            }
            forDrop();
            System.out.println("Pick a student: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > student.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Student selectedStudent = student.get(option - 1);


            if(selectedStudent.getIsEnrolled().equals("Not-Enrolled")) {
                System.out.println("Student not enrolled.");
                return;
            }


            if(selectedStudent.getIsEnrolled().equals("Enrolled")) {
                selectedStudent.displayCourse();
            }

            System.out.println("Pick a course to drop: ");
            int option2;

            try {
                option2 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }
            
            Course selectedCourse = selectedStudent.getEnrolledCourses(option2);

            if(selectedCourse == null) {
                continue;
            }
            selectedStudent.dropCourse(selectedCourse);
            selectedCourse.removeStudents(selectedStudent);
            return;
        }
    }

    void forDrop() {
        int counter = 1;
        for(int i = 0; i < student.size(); i++) {
            Student display = student.get(i);
                if(display.getIsEnrolled().equals("Enrolled")) {
                    System.out.println((counter + ".) " 
                    + "Student name: " + display.getStudentName() 
                    + " | Student ID: " + display.getStudentID()));
                    counter++;
            }
        }
        return;
    }

    void viewStudentCourse() {
        while(true) {
            System.out.println("=====VIEW-STUDENTS'-COURSE=====");
            System.out.println("Enter a student name: ");
            String view = scanner.nextLine();

            if(view.isEmpty()) {
                System.out.println("Student field cannot be empty.");
                return;
            }

            for(int i = 0; i < student.size(); i++) {
                Student display = student.get(i);
                if(view.equals(display.getStudentName())) {
                    System.out.println("Student found.");
                    System.out.println("Courses' enrolled: ");
                    System.out.println("Student name: " + display.getStudentName() + " | Student ID: " + display.getStudentID());
                    display.displayCourse();
                    return;
                }
            }
            System.out.println("Student not found.");
            return;
        }
    }
    void viewCourseStudent() {
        while(true) {
            System.out.println("=====VIEW-COURSE-STUDENT=====");
            System.out.println("Enter a course name: ");
            String view = scanner.nextLine();

            if(view.isEmpty()) {
                System.out.println("Course field cannot be empty.");
                return;
            }

            for(int i = 0; i < course.size(); i++) {
                Course display = course.get(i);
                if(view.equals(display.getCourseTitle())) {
                    System.out.println("Course found.");
                    System.out.println("Enrolled students:");
                    System.out.println("Course name: " + display.getCourseTitle() + " | Course code: " + display.getCourseCode());
                    display.displayStudents();
                    return;
                }
            }
            System.out.println("Course not found.");
            return;
        }
    }
    void searchStudent() {
        while(true) {
            System.out.println("=====SEARCH-STUDENT=====");
            System.out.println("Enter a student name: ");
            String search = scanner.nextLine();
            for(int i = 0; i < student.size(); i++) {
                Student searchStudent = student.get(i);
                if(search.equals(searchStudent.getStudentName())) {
                    System.out.println("Student found.");
                    System.out.println("Student name: " + searchStudent.getStudentName() + " | Student ID: " + searchStudent.getStudentID() + " | Status: " + searchStudent.getIsEnrolled());
                    return;
                }
            }

            System.out.println("Student not found.");
            return;
        }
    }
    void searchCourse() {
        while(true) {
            System.out.println("=====SEARCH-COURSE=====");
            System.out.println("Enter a course name: ");
            String search = scanner.nextLine();
            for(int i = 0; i < course.size(); i++) {
                Course searchCourse = course.get(i);
                if(search.equals(searchCourse.getCourseTitle())) {
                    System.out.println("Course found.");
                    System.out.println("Course name: " + searchCourse.getCourseTitle() + " | Course code: " + searchCourse.getCourseCode());
                    return;
                }
            }

            System.out.println("Course not found.");
            return;
        }
    }
}
