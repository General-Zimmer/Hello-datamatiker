package modul.opgave2;

public class Util {

    public static double getAverage(double[] grades) {

        double i = 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
            i++;
        }
        return sum/i;
    }

    public static int getcorrectAnswers(Student.answers[] answers, Student.answers[] correctAnswers) {
        int correctAnswersCount = 0;


        for (int i = 0; i < correctAnswers.length; i++)
            if (answers[i] == correctAnswers[i])
                correctAnswersCount++;

        return correctAnswersCount;
    }

}
