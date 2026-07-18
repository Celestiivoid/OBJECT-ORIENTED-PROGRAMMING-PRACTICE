package FILEBASEDSTUDENTENROLLMENT;
import java.util.Scanner;
import java.util.ArrayList;
class Course {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> enrolledStudent = new ArrayList<>();
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

    String addStudents(Student student) {
        if(availableSlots <= 0) {
            return "Course full";
        }
        if(enrolledStudent.contains(student)) {
            return student.getStudentName() + " is already enrolled";
        }
        enrolledStudent.add(student);
        availableSlots--;
        return "Successfully enrolled";
    }
    void removeStudents(Student student) {
        enrolledStudent.remove(student);
        availableSlots++;
    }


    void displayStudents() {
        if(enrolledStudent.isEmpty()) {
            System.out.println("No enrolled students.");
            return;
        }

        for(int i = 0; i< enrolledStudent.size(); i++) {
            Student display = enrolledStudent.get(i);
            System.out.println((i + 1) + ".) " + display.getStudentName());
        }
    }

    Student getEnrolledStudent(int enrolledIndex) {
        if(enrolledIndex < 1 || enrolledIndex > enrolledStudent.size()) {
            System.out.println("Out of range!");
            return null;
        }
        return enrolledStudent.get(enrolledIndex - 1);
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
