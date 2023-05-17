package opgaver.exercise6;

@SuppressWarnings("all")
public class Student {
    private final String name;
    private final boolean active;
    private final double[] grades;
    private final answers[] multipleChoiceAnswers;
    private int age;
    enum answers {
        a, b, c, d
    }

    public Student(String name, boolean active, double[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.multipleChoiceAnswers = new answers[10];
        for (int i = 0; i < multipleChoiceAnswers.length; i++)
            multipleChoiceAnswers[i] = randomChoice();

    }

    public Student(String name, boolean active, int age) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.grades = new double[]{00.0};
        this.multipleChoiceAnswers = new answers[10];
        for (int i = 0; i < multipleChoiceAnswers.length; i++)
            multipleChoiceAnswers[i] = randomChoice();

    }

    public answers randomChoice() {
        double random = Math.random();

        if (random <= 0.25)
            return answers.a;
        else if (random <= 0.50)
            return answers.b;
        else if (random <= 0.75)
            return answers.c;
        else
            return answers.d;
    }

    public int getHighestGrade() {
        int biggest = -99;
        for (double grade : grades) {
            if (biggest < grade)
                biggest = (int) grade;
        }
        return biggest;
    }

    public double getAverage() {
        return Util.getAverage(grades);
    }

    @Override
    public String toString() {
        String space = "  :  ";
        return String.format("%-20s", name) + space + String.format("%-6s", getAverage()) + space;
    }

    public String getName() {
        return name;
    }
    public boolean isActive() {
        return active;
    }

    public answers[] getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

}
