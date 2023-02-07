package Opgaver;

public class Opgave5 {
    public static void main(String[] args) {


        System.out.println(team(true, 89));
        System.out.println(team(true, 8));
        System.out.println(team(true, 3));
        System.out.println(team(false, 57));
        System.out.println(team(false, 8));
        System.out.println(team(false, 5));
    }

    public static String team(boolean isBoy, int age) {

        //Drenge teams
        if (isBoy) {
         if (age < 8)
             return "Young cubs";
         else
             return "Cool boys";
        }
        //Pige teams
        else {
            if (age < 8)
                return "Tumbling girls";
            else
                return "Springy girls";
        }

    }

}
