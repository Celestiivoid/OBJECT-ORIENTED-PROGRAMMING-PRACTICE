package STUDENTGRADINGSYSTEM;
import java.util.Scanner;
import java.util.ArrayList;

class StudentService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> student = new ArrayList<>();
    
    void addStudent() {
        while(true) {
            System.out.println("=====ADD-STUDENT=====");
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Name field cannot be empty.");
                continue;
            }

            for(int i = 0; i < student.size(); i++) {
                Student find = student.get(i);
                if(name.equalsIgnoreCase(find.passName())) {
                    System.out.println("Student name already exist.");
                    return;
                }
            }

            Student newStudent = new Student(name);
            student.add(newStudent);
            System.out.println("Successfully enrolled student!");
            return;
        }
    }
    void viewStudents() {
        System.out.println("=====VIEW-STUDENTS=====");
        if(student.isEmpty()) {
            System.out.println("No students registered at the moment.");
            return;
        }

        for(int i = 0; i < student.size(); i ++) {
            Student view = student.get(i);
            System.out.println((i + 1) + ".) " + " Name: " + view.passName() + "| Grade status: " + view.isGraded());
        }
    }
    void gradeStudents() {
        while(true) {
            if(student.isEmpty()) {
                viewStudents();
                return;
            }
            for(int i = 0; i < student.size(); i ++) {
            Student view = student.get(i);
            System.out.println((i + 1) + ".) " + "Name: " + view.passName());
            }
            System.out.println("Pick a student to grade: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }
            
            if(option > student.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Student selectedStudent = student.get(option - 1);

            if(selectedStudent.passQuizScore() > 0.0) {
                System.out.println("Student already graded.");
                return;
            }

            System.out.println("Enter quiz score: ");
            double quiz;

            try {
                quiz = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            System.out.println("Enter exam score: ");
            double exam;

            try {
                exam = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            String result = selectedStudent.setScores(quiz,exam);
            System.out.println(result);
            return;
        }
    }
    void viewStudentReport() {
        while(true) {
            System.out.println("=====VIEW-STUDENT-REPORT=====");

            if(student.isEmpty()) {
                System.out.println("No recorded students.");
                return;
            }

            for(int i = 0; i < student.size(); i++) {
                Student viewReport = student.get(i);
                System.out.println((i + 1) + ".) " + viewReport.passName());
            }

            System.out.println("Pick student: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick < 1 || pick > student.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Student selectedStudent = student.get(pick - 1);
            selectedStudent.displayReport();
            return;
        }
    }
    void searchStudent() {
        while(true) {
            System.out.println("=====SEARCH-STUDENT=====");

            if(student.isEmpty()) {
                System.out.println("No registered students.");
                return;
            }

            System.out.println("Search student by name: ");
            String searchName = scanner.nextLine();

            for(int i = 0; i < student.size(); i++) {
                Student search = student.get(i);
                if(searchName.equalsIgnoreCase(search.passName())) {
                    System.out.println("Student found!");
                    System.out.println("Student name: " + search.passName() + " | Average: " + search.calculateAverage());
                    return;
                }
            }

            System.out.println("Student not found.");
            return;
        }
    }
}
