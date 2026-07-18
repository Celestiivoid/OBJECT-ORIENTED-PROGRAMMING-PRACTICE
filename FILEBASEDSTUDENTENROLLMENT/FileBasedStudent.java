package FILEBASEDSTUDENTENROLLMENT;
import java.util.ArrayList;

class Student {
   private ArrayList<Course> enrolledCourse = new ArrayList<>();

    private int studentID;
    private String studentName;
    Student(int  studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }    

    void enrollCourse(Course course) {
        if(enrolledCourse.contains(course)) {
            System.out.println("You already enrolled for this subject.");
            return;
        }
        enrolledCourse.add(course);
    }

    void dropCourse(Course course) {
        enrolledCourse.remove(course);
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
        if(!enrolledCourse.isEmpty()) {
            return "Enrolled";
        }
        else {
            return "Not-enrolled";
        }
    }

    Course getEnrolledCourses(int enrolledIndex) {
        if(enrolledIndex < 1 || enrolledIndex > enrolledCourse.size()) {
            System.out.println("Out of range!");
            return null;
        }
        return enrolledCourse.get(enrolledIndex - 1);
    }
    int getStudentID() {
        return studentID;
    }

    String getStudentName() {
        return studentName;
    }

    ArrayList<Course> getEnrolledCourses() {
        return enrolledCourse;
    }
}
