package FILEBASEDSTUDENTENROLLMENT;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
class FileManager {
    
    void saveStudents(ArrayList<Student> students) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("students.csv"));
        for(Student student : students) {
            save.write(student.getStudentID() + "," + student.getStudentName());
            save.newLine();
        }
        save.close();
    }

    void loadStudents(ArrayList<Student> students) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("students.csv"));
        String line;
        while((line = load.readLine()) != null) {
            String [] studentData = line.split(",");
            int idNumber = Integer.parseInt(studentData[0]);
            String name = studentData[1];
            students.add(new Student(idNumber, name));
        }
        load.close();
    }
    void saveCourse(ArrayList<Course> courses) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("courses.csv"));
        for(Course course : courses) {
            save.write(course.getCourseCode() + "," + course.getCourseTitle() + "," + course.getMaxSlot() + "," + course.getAvailableSlots());
            save.newLine();
        }
        save.close();
    }
    void loadCourse(ArrayList<Course> courses) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("courses.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] courseData = line.split(",");
            int courseCode = Integer.parseInt(courseData[0]);
            String courseName = courseData[1];
            int courseMaxSlots = Integer.parseInt(courseData[2]);
            int courseAvailableSlots = Integer.parseInt(courseData[3]);
            courses.add(new Course(courseCode, courseName, courseMaxSlots, courseAvailableSlots));
        }
        load.close();
    }
    void saveEnrollment(ArrayList<Student> students, ArrayList<Course> courses) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter("enrollment.csv"));
        for(Student student : students) {
            for( Course course : student.getEnrolledCourses()) {
                save.write(student.getStudentID() + "," + course.getCourseCode());
                save.newLine();
            }
        }
        save.close();
    }
    void loadEnrollment(ArrayList<Student> students, ArrayList<Course> courses) throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("enrollment.csv"));
        String line;

        while((line = load.readLine()) != null) {
            String [] enrollmentData = line.split(",");
            int enrolledID = Integer.parseInt(enrollmentData[0]);
            int enrolledCourseCode = Integer.parseInt(enrollmentData[1]);
            Student targetS = students.get(enrolledID);
            Course targetC = courses.get(enrolledCourseCode);
            targetS.enrollCourse(targetC);
            targetC.addStudents(targetS);
        }
        load.close();
    }
}
