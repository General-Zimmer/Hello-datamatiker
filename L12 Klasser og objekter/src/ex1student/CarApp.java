package ex1student;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        System.out.println("Test: " + myCar);
        System.out.println();

        String brand = myCar.brand;
        System.out.println("Brand " + brand);
        System.out.println("My car: " + myCar.brand + ", " + myCar.color);

        myCar.km = 65000;
        System.out.println("Km nu: " + myCar.km);
    }
}
