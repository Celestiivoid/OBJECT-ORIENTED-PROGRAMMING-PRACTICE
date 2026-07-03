package STUDENTGRADINGSYSTEM;

class Student {
    private String studentName;
    private double quizScore;
    private double examScore;
    private double average;

    Student(String studentName) {
        this.studentName = studentName;
        this.quizScore = 0;
        this.examScore = 0;
    }

    String setScores(double sQuizScore, double sExamScore) {
        if(sQuizScore <= 0.0 || sExamScore <= 0.0) {
            return "Score cannot go below 0.";
        }
        if(sQuizScore > 100.0 || sExamScore > 100.0) {
            return "Score cannot exceed 100.";
        }
        quizScore += sQuizScore;
        examScore += sExamScore;
        return "Successfully graded, " + studentName + ".";
    }
    String calculateAverage() {
        average = quizScore + examScore / 2;
        return "Average: " + average;
    }
    String isPassed() {
        if(average >= 75) {
            return "Status: Passed";
        }
        else {
            return "Status: Failed";
        }
    }
    void displayReport() {
        System.out.println("Name: " + studentName);
        System.out.println("Quis Score: " + quizScore);
        System.out.println("Exam Score: " + examScore);
        System.out.println(calculateAverage());
        System.out.println(isPassed());
    }

    String passName() {
        return studentName;
    }
    Double passQuizScore() {
        return quizScore;
    }
    Double passExamScore() {
        return examScore;
    }
    String isGraded() {
        if(examScore != 0.0 && quizScore != 0.0) {
            return "Graded";
        }
        else {
            return "Not Graded";
        }
    }
}
