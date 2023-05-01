package yeet;

import java.util.ArrayList;

public class Methods {
    @SuppressWarnings("unchecked")
    public static ArrayList<?> sort(ArrayList<? extends Comparable> array) {

        ArrayList<?> newArray = new ArrayList<>(array);
        for (int i = 0; i < array.size()-1; i++) {
            var minNum = array.get(i);
            for (int j = i+1; j < array.size(); j++) {

                if (array.get(j).compareTo(minNum) > 0) {

                }
            }
        }

        return null;
    }
}
