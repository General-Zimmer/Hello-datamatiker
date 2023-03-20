package modul.opgave1;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;



    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", active=" + active +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }

    public String getName() {
        return name;
    }

}
