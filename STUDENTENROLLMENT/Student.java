package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<Course> course = new ArrayList<>();

    private int studentID;
    private String studentName;
    Student(int  studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }    

    void enrollCourse() {

    }
    void dropCourse() {

    }
    void displayCourse() {

    }
    void isEnrolled() {

    }

    int getStudentID() {
        return studentID;
    }
    String getStudentName() {
        return studentName;
    }
}
