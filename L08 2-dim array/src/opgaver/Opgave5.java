package opgaver;

import java.util.HashMap;
import java.util.Map;

public class Opgave5 {
    public static void main(String[] args) {
        HashMap<String, Integer> salg = new HashMap<>();
        salg.put("cola", 8);
        salg.put("Pepsi", 3);
        salg.put("Danskvand", 15);

        printHistogram(salg);

    }

    public static void printHistogram(HashMap<String, Integer> salg) {
        for (Map.Entry<String, Integer> entry : salg.entrySet()) {
            System.out.printf(entry.getKey() + "%" + (11-entry.getKey().length()) + "s", " ");
            for (int j = 0; j < entry.getValue(); j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
