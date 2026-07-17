package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
   static Scanner scanner = new Scanner(System.in);
   private ArrayList<Course> enrolledCourse = new ArrayList<>();

    private int studentID;
    private String studentName;
    private boolean isEnrolled;
    Student(int  studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.isEnrolled = false;
    }    

    void enrollCourse(Course course) {
        if(enrolledCourse.contains(course)) {
            System.out.println("You already enrolled for this subject.");
            return;
        }
        isEnrolled = true;
        enrolledCourse.add(course);
    }

    void dropCourse(Course course) {
        enrolledCourse.remove(course);

        if(enrolledCourse.isEmpty()) {
            isEnrolled = false;
        }
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

    String getIsEnrolled() {
        if(isEnrolled) {
            return "Enrolled";
        }
        else {
            return "Not-Enrolled";
        }
    }

    int getStudentID() {
        return studentID;
    }

    String getStudentName() {
        return studentName;
    }
}
