package opgaver.exercise1;

public class Car {


    private final String brand;
    private final String color;
    private final String regNo; // registration number
    private int km;

    public Car(String brand, String color, String regNo, int km) {
        this.brand = brand;
        this.color = color;
        this.regNo = regNo;
        this.km = km;
    }

    public void printBrandColor() {
        System.out.printf("Brand is %s and color is %s", brand, color);
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return String.format("Car(%s, %s, %s, %d km)", brand, color, regNo, km);
    }
}
