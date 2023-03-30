package modul.opgave3;

import java.util.Scanner;

public class MenuApp {
    private static final Scanner scan = new Scanner(System.in);

    // I used ArrayList in the start. Classmates' lack of using it convinced me otherwise
    private static final Team[] teams = new Team[10];
    private static int teamAmount = 0;

    public static void main(String[] args) {

        // For testing purposes without JUnit tests
        Team team = new Team("Team over 9000", "earth");
        Student dinMads = new Student("Mads åermand", true, new double[]{0, 0, 1000, 5});
        Student minMads = new Student("Mads byerskand", true, new double[]{421, 4});
        Student notSoProudPanda = new Student("Panda of Braveness", true, new double[]{9001, 9001, 9001});
        team.addStudent(dinMads);
        team.addStudent(minMads);
        team.addStudent(notSoProudPanda);
        addTeam(team);


        

        int input = 0;
        while (input != 6) {

            System.out.println("""
                    MENU
                    1: Create a team
                    2: Create a student
                    3: Show one student's info and results
                    4: Show one team's info and results
                    5: Show info and results for all teams
                    6: Exit program""");

            input = scan.nextInt();

            scan.nextLine();

            switch (input) {
                case 1 -> createTeam();
                case 2 -> CreateStudent();
                case 3 -> showStudentInfo();
                case 4 -> showTeamInfo();
                case 5 -> showAllTeamInfo();
            }

            System.out.println();

        }


    }

    public static void createTeam() {

        System.out.println("Name of team");
        String name = scan.nextLine();

        System.out.println("Room of team");
        String room = scan.nextLine();

        addTeam(new Team(name, room));
    }

    public static void CreateStudent() {
        System.out.println("Which team should the student be added to?");
        String teamName = scan.nextLine();
        System.out.println("Gib student name");
        String name = scan.nextLine();
        System.out.println("Is student active?");
        boolean active = scan.nextBoolean();

        System.out.println("How many grades to register?");
        int gradeAmount = scan.nextInt();
        double[] grades = new double[gradeAmount];
        System.out.println("Give us the grades");
        for (int i = 0; i < gradeAmount; i++) {
            grades[i] = scan.nextDouble();
        }


        Team team = Util.getTeam(teams, teamName);
        if (team != null)
            team.addStudent(new Student(name, active, grades));
        else
            System.out.println("Team didn't exist");

    }

    public static void showStudentInfo() {

        System.out.println("Which team is the student on?");
        String teamName = scan.nextLine();
        System.out.println("Gib student name");
        String name = scan.nextLine();
        

        Team team = Util.getTeam(teams, teamName);
        
        if (team != null)
            for (Student student : team.getStudents()) {

                if (student != null && student.getName().equalsIgnoreCase(name))
                    System.out.println(team.getStudentInfo(name));
            }

    }

    public static void showTeamInfo() {
        System.out.println("Which team?");
        String teamName = scan.nextLine();
        Team team = Util.getTeam(teams, teamName);

        if (team == null) {
            System.out.println("Team doesn't exist");
            return;
        }

        for (String studentInfo : team.teamInfo())
            System.out.println(studentInfo);
    }

    public static void showAllTeamInfo() {

        for (Team team : teams) {
            if (team == null) continue;

            System.out.println("Team: " + team.getName());
            for (String studentInfo : team.teamInfo())
                if (studentInfo != null)
                    System.out.println(studentInfo);
        }
    }

    private static void addTeam(Team team) {
        if (teamAmount > 32) {
            System.out.println("Can't create more teams");
            return;
        }

        teams[teamAmount] = team;
        teamAmount++;
    }

}
