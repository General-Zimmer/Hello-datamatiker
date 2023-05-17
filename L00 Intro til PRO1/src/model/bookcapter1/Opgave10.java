package model.bookcapter1;

public class Opgave10 {
    public static void main(String[] args) {
        double miles = 15/1.6;
        double time = (50/60.0)+(30/60.0/60.0);
        System.out.println(miles);
        System.out.println(time);

        double AverageSpeed = miles*(1+(1-time));
        System.out.println(AverageSpeed);
    }
}
