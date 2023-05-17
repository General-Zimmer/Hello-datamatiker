package opgaver.exercise1;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);

        myCar.printBrandColor();
        System.out.println();
        myCar.setKm(9001);
        System.out.println(myCar.getKm());

        System.out.println(myCar);
    }
}
