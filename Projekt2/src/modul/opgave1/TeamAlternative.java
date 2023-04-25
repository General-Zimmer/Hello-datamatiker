package modul.opgave1;


import java.util.Arrays;

@SuppressWarnings("all")
public class TeamAlternative {

    private String name;
    private String room;
    private int studentAmount;
    private Student[] student;

    public TeamAlternative(String name, String room) {
        this.name = name;
        this.room = room;
        this.studentAmount = 0;
        this.student = new Student[0];
    }


    public void addStudent(Student student) {

        studentAmount++;
        Student[] addStudent = new Student[studentAmount];
        for (int i = 0; i < this.student.length; i++) {
            addStudent[i] = this.student[i];
        }
        addStudent[studentAmount - 1] = student;
        this.student = addStudent;
    }

    public void removeStudent(String name) {
        studentAmount--;
        Student[] removeStudent = new Student[studentAmount];
        boolean isStudentRemoved = false;



        for (int i = 0, j = 0; i < student.length; i++) {

            try {
                if (!this.student[i].getName().equalsIgnoreCase(name)) {
                    removeStudent[j] = this.student[i];
                    j++;
                } else {
                    isStudentRemoved = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Student '" + name + "' isn't in this team");
            }

        }
        if (!isStudentRemoved) {
            studentAmount++;
            return;
        }

        this.student = removeStudent;

    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", studentAmount=" + studentAmount +
                ", student=" + Arrays.toString(student) +
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

    public int getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount = studentAmount;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }
}