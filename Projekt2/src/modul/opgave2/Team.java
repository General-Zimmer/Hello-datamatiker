package modul.opgave2;

import java.util.Arrays;

public class Team {

    private final String name;
    private final String room;
    private int studentAmount;
    private final Student[] students;

    private static final Student.answers[] correctAnswers = new Student.answers[10];
    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.studentAmount = 0;
        this.students = new Student[32];

        Arrays.fill(correctAnswers, Student.answers.a);
    }

    public Student[] gethighScoreStudents(double minAverage) {
        Student[] highStudents = new Student[studentAmount];

        for (int i = 0; i < studentAmount; i++) {
            Student student = students[i];

            if (student.isActive() && student.getAverage() >= minAverage)
                highStudents[i] = student;
        }
        return highStudents;
    }

    public void removeStudent(String name) {

        boolean isStudentRemoved = false;


        for (int i = 0; i < students.length; i++) {

            if (isStudentRemoved && i != students.length-1) {
                students[i] = students[i+1];
            }
            else if (students[i] != null && i == students.length-1 && students[i].getName().equalsIgnoreCase(name)) {
                students[i] = null;
                isStudentRemoved = true;
            }
            else if (students[i] != null && this.students[i].getName().equalsIgnoreCase(name)) {
                students[i] = students[i+1];
                isStudentRemoved = true;
            }

        }
        if (isStudentRemoved)
            studentAmount--;
    }

    //todo Average of all grades, not all students
    public double getTeamAverage() {

        double[] studentGrades = new double[studentAmount];
        for (int i = 0; i < studentAmount; i++)
            studentGrades[i] = students[i].getAverage();


        return Util.getAverage(studentGrades);
    }

    public int[] correctAnswersCount() {

        int[] correctAnswersCount = new int[10];

        for (int i = 0; i < studentAmount; i++) {
            Student student = students[i];
            Student.answers[] answers = student.getMultipleChoiceAnswers();

            for (int j = 0; j < correctAnswersCount.length; j++) {
                if (answers[j] == correctAnswers[j])
                    correctAnswersCount[j]++;
            }
        }
        return correctAnswersCount;
    }

    public void addStudent(Student student) {

        students[studentAmount] = student;
        studentAmount++;
    }

    public String[] teamInfo() {
        String[] stringStudents = new String[studentAmount+1];

        stringStudents[0] = "     Navn           Genm. kara.  rigtige svar på multiple choice";


        for (int i = 1; i < studentAmount+1; i++) {
            Student.answers[] answers = students[i-1].getMultipleChoiceAnswers();

            int correctAnswersCount = Util.getcorrectAnswers(answers, correctAnswers);

            stringStudents[i] = students[i-1].toString() + String.format("%-2s", correctAnswersCount);
        }

        return stringStudents;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", studentAmount=" + studentAmount +
                ", students=" + Arrays.toString(students) +
                '}';
    }


}
