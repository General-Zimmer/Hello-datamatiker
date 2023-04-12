package opgaver.opgave1;

import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        // TODO
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[index] is true, if die no. index is hold (for index in [0..4]).
     */
    public void throwDice(boolean[] holdStatus) {
        // TODO
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        int[] frequency = new int[7];

        for (int value : values)
            frequency[value]++;


        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int checkValue) {
        int amount = 0;

        for (int value : values)
            if (value == checkValue)
                amount++;


        return amount*checkValue;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int[] frequencies = frequency();

        // Find pairs
        for (int i = frequencies.length-1; i > 1; i--)
            if (frequencies[i] >= 2)
                return i*2;

        return 0;
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int[] data = frequency();
        int highestPairPoints = onePairPoints();

        if (highestPairPoints == 0) return 0;

        for (int i = data.length-1; i > 1; i--) {
            int frequency = data[i];
            int maybeHighestPoints = i*2;

            if (maybeHighestPoints < highestPairPoints && frequency >= 2)
                return maybeHighestPoints + highestPairPoints;
        }

        return 0;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        int[] frequencies = frequency();

        for (int i = 1; i < frequencies.length; i++)
            if (frequencies[i] >= 3)
                return i*3;

        return 0;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        int[] frequencies = frequency();

        for (int i = 1; i < frequencies.length; i++)
            if (frequencies[i] >= 4)
                return i*4;

        return 0;
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int temp = 0;
        int[] frequencies = frequency();

        for (int i = 1; i < frequencies.length; i++) {

            // Finds 2nd condition by subtracting total frequencies by frequencies in the current temp number
            // to find the remaining frequencies
            if (temp != 0 && frequencies.length-frequencies[temp] == frequencies[i])
                // calculate the scores by multiplying their dice count with frequency
                return frequencies[i] * i + frequencies[temp] * temp;

            // Finds first condition
            if (frequencies[i] == 3 || frequencies[i] == 2)
                temp = i;
        }

        // in case full house isn't found
        return 0;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int[] frequencies = frequency();
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            if (frequencies[i] == 1)
                sum += i;
        }

        if (sum == 15)
            return sum;
        else
            return 0;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int[] frequencies = frequency();
        int sum = 0;

        for (int i = 2; i <= 6; i++) {
            if (frequencies[i] == 1)
                sum += i;
        }
        if (sum == 20)
            return sum;
        else
            return 0;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int sum = 0;

        for (int value : values)
            sum += value;


        return sum;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {

        int[] frequencies = frequency();

        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] == 5)
                return 50;
        }

        return 0;
    }
}
