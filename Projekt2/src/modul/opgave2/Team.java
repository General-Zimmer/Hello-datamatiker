package modul.opgave2;

import java.util.Arrays;

public class Team {

    private String name;
    private String room;
    private int studentAmount;
    private Student[] students;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.studentAmount = 0;
        this.students = new Student[32];
    }

    public void addStudent(Student student) {


        students[studentAmount] = student;

        studentAmount++;

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


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", studentAmount=" + studentAmount +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount = studentAmount;
    }
}
