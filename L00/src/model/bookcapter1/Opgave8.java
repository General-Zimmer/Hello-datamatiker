package model.bookcapter1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Opgave8 {
    public static void main(String[] args) {
        double Pi = 3.14159;
        double Radius = 6.5;


        double Perimeter = 2*Radius*Pi;
        double area = Radius*Radius*Pi;

        System.out.println(Perimeter);
        System.out.println(area);
        Logger.getLogger("Yeet").log(Level.WARNING, "This is a test warning!!!!");

    }
}
