package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
   static Scanner scanner = new Scanner(System.in);
   private ArrayList<Course> enrolledCourse = new ArrayList<>();

    private int studentID;
    private String studentName;
    Student(int  studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }    

    void enrollCourse(Course course) {
        enrolledCourse.add(course);
    }
    void dropCourse() {

    }
    void displayStudent() {

    }
    void displayCourse() {
        if(enrolledCourse.isEmpty()) {
            System.out.println("No enrolled course.");
            return;
        }

        for(int i = 0;  i < enrolledCourse.size(); i++) {
            Course display = enrolledCourse.get(i);
            System.out.println((i + 1) + ".) " + display.getCourseTitle());
        }
    }

    int getStudentID() {
        return studentID;
    }
    String getStudentName() {
        return studentName;
    }
}
