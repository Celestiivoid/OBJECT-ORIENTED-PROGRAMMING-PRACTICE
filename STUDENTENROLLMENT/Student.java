package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<Course> course = new ArrayList<>();

    private int studentID;
    private String studentName;
    private boolean isEnrolled;
    Student(int  studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.isEnrolled = false;
    }    

    String enrollCourse() {
        for(int i = 0; i < course.size(); i++) {
            Course check = course.get(i);
            if(check.getAvailableSlots() <= 0) {
                return "No remaining slot for this subject.";
            }
        }
        isEnrolled = true;
        return "Successfully enrolled.";
    }
    void dropCourse() {

    }
    void displayStudent() {

    }
    void displayCourse() {

    }
    String getIsEnrolled() {
        if(isEnrolled) {
            return "Enrolled";
        }
        return "Not enrolled";
    }

    int getStudentID() {
        return studentID;
    }
    String getStudentName() {
        return studentName;
    }
}
