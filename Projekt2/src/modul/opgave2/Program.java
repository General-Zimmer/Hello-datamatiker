package modul.opgave2;

public class Program {

    public static void main(String[] args) {
        Team team1 = new Team("Team over 9000", "earth");
        Team team2 = new Team("Team under 9000", "mars");


        Student dinMads = new Student("Mads åermand", true, new double[]{0, 0, 1000, 5});
        Student minMads = new Student("Mads byerskand", true, new double[]{421, 4});
        Student notSoProudPanda = new Student("Panda of Braveness", true, new double[]{9001, 9001, 9001});
        Student morsAndreas = new Student("Andreas Lomberjack", true, new double[]{5});
        Student koKurt = new Student("Kurt Tykkster", true, new double[]{999, 999, 999, 999});
        Student proudpanda = new Student("Panda of Proudness", true, new double[]{9001, 9001, 9001});


        // Add test
        team1.addStudent(dinMads);
        team1.addStudent(minMads);
        team1.addStudent(notSoProudPanda);
        team2.addStudent(morsAndreas);
        team2.addStudent(koKurt);
        team2.addStudent(proudpanda);

        // Highest grade test
        System.out.println(dinMads.getName() + " has a highest grade of " + dinMads.getHighestGrade());

        System.out.println();

        // Team info test
        for (String student : team1.teamInfo())
            System.out.println(student);
        System.out.println();
        for (String student : team2.teamInfo())
            System.out.println(student);

        System.out.println();


        //Team grade average test
        System.out.println("Team 1 grade average: " + team1.getTeamAverage());
        System.out.println("Team 2 grade average: " + team2.getTeamAverage());

        System.out.println();

        // Highscore Method test
        System.out.println("all Highscore students");
        for (Student student : team1.gethighScoreStudents(100)) {
            if (student != null)
                System.out.println(student.getName());
        }

        for (Student student : team2.gethighScoreStudents(100)) {
            if (student != null)
                System.out.println(student.getName());
        }

        System.out.println();

        int[] team1CorrectAnswers = team1.correctAnswersCount();
        System.out.println("Team 1");
        for (int i = 0; i < team1CorrectAnswers.length; i++)
            System.out.println("Question " + (i+1) + " correct answers: " + team1CorrectAnswers[i]);
        int[] team2CorrectAnswers = team2.correctAnswersCount();
        System.out.println("Team 2");
        for (int i = 0; i < team2CorrectAnswers.length; i++)
            System.out.println("Question " + (i+1) + " correct answers: " + team2CorrectAnswers[i]);

        // Remove test
        team2.removeStudent(proudpanda.getName());
        team1.removeStudent(dinMads.getName());



    }

}
