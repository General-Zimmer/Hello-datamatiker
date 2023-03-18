package modul.opgave2;

public class Program {

    public static void main(String[] args) {
        Team team1 = new Team("Team over 9000", "earth");
        Team team2 = new Team("Team under 9000", "mars");


        Student dinMads = new Student("Mads åermand", true, new int[]{0, 0, 1000, 5});
        Student minMads = new Student("Mads byerskand", true, new int[]{421, 4});
        Student notSoProudPanda = new Student("Panda of Braveness", true, new int[]{9001, 9001, 9001});
        Student morsAndreas = new Student("Andreas Lomberjack", true, new int[]{5});
        Student koKurt = new Student("Kurt Tykkster", true, new int[]{999, 999, 999, 999});
        Student proudpanda = new Student("Panda of Proudness", true, new int[]{9001, 9001, 9001});


        team1.addStudent(dinMads);
        team1.addStudent(minMads);
        team1.addStudent(notSoProudPanda);
        team2.addStudent(morsAndreas);
        team2.addStudent(koKurt);
        team2.addStudent(proudpanda);

        System.out.println(team1);
        System.out.println(team2);

        team2.removeStudent(proudpanda.getName());
        team1.removeStudent(dinMads.getName());

        System.out.println(team1);
        System.out.println(team2);

    }

}
