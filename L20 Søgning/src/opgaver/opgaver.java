package opgaver;

import opgaver.util.Methods;
import opgaver.util.Player;

import java.util.ArrayList;

public class opgaver {
    public static void main(String[] args) {


        exercise4();

    }

    /**
     * Write a linear search method that returns, whether an uneven number exists in an array. The
     * method must return true or false, and take an array of integer numbers as parameter.
     * Test the method.
     *
     */
    public static int exercise1(int[] array) {

        return 0;
    }

    /**
     *
     * Write a linear search method that finds the first number belonging to the interval [10;15]. The
     * method must return the number found in the interval, and take an array of integer numbers as
     * parameter. If a number in the interval is not found, the method must return -1.
     * Test the method.
     * If the array is [7, 56, 34, 3, 7, 14, 13, 4], the method should return 14.
     */
    public static int exercise2(int[] array) {


        return 0;

    }

    public static int exercise3() {

        return 0;

    }


    /**
     *
     * In this exercise you must use a Player class. Make a player class with the following fields:
     * name, height, weight, scoredGoals. The class must have a constructor that initializes all the
     * fields, and get methods for all four fields (and a toString() method).
     * In the test class make an ArrayList of Player with about 6-8 Players.
     * a) Write a linear search method that returns a player with a given number of scored goals
     * found in an ArrayList of players given as parameter. Return null, if no such player is found.
     * <p>
     * The header of the method:
     * public Player findPlayerLinear(ArrayList<Player> players, int score)
     * b) Write a binary search method that returns a player with a given number of scored goals
     * found in a sorted ArrayList of players (sorted in descending order according to scored goals)
     * given as parameter. Return null, if no such player is found.
     * The header of the method:
     * public Player findPlayerBinary(ArrayList<Player> players, int score)
     * c) Write a linear search method that returns the name of a player with a height less than 170
     * cm and with more than 50 scored goals in a given ArrayList of players. Return the empty
     * string, if no player is found.
     * The header of the method:
     * public String findPlayerName(ArrayList<Player> players)
     */

    @SuppressWarnings("ConstantConditions")
    public static void exercise4() {

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            players.add(new Player("Mads"+i, (int) (Math.random() * 40 + 160), (int) (Math.random() * 20 + 60), (int) (Math.random() * 70 + 30)));

        players.add(new Player("Mads", 160, 69, 60));



        // A
        Player player1 = Methods.findPlayerLinear(players, 60);
        if (player1 == null)
            System.out.println("IT IS NULL!");
        else
            System.out.println(player1.getName() + "  " + player1.getScoredGoals());


        // B




    }

}
