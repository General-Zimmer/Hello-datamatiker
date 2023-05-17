package opgaver.util;

import java.util.ArrayList;

public class Methods {

    public static Player findPlayerLinear(ArrayList<Player> players, int score) {

        for (Player player : players)
            if (player.getScoredGoals() == score)
                return player;

        return null;
    }

    public String findPlayerName(ArrayList<Player> players) {



        return "";
    }

}
