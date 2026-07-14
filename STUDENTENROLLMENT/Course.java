package STUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;
class Course {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> student = new ArrayList<>();
    private int courseCode;
    private String courseTitle;
    private int maxSlots;
    private int availableSlots;

    Course(int courseCode, String courseTitle, int maxSlots, int availableSlots) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.maxSlots = maxSlots;
        this.availableSlots = availableSlots;
    }

    void addStudents() {

    }
    void removeStudents() {

    }
    void displayCourse() {

    }
    void isFull() {

    }

    int getCourseCode() {
        return courseCode;
    }
    String getCourseTitle() {
        return courseTitle;
    }
    int getMaxSlot() {
        return maxSlots;
    }
    int getAvailableSlots() {
        return availableSlots;
    }
}
