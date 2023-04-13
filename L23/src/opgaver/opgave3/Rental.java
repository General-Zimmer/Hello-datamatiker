package opgaver.opgave3;

import java.util.ArrayList;

public class Rental {
    private final int no;
    private final String Date;
    private int days;
    private final ArrayList<Car> cars = new ArrayList<>();

    public Rental(int no, String date, int days) {
        this.no = no;
        this.Date = date;
        this.days = days;
    }


    public void addCar(Car car) {
        cars.add(car);
    }
    public int getNo() {
        return no;
    }

    public String getDate() {
        return Date;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "no=" + no +
                ", Date='" + Date + '\'' +
                ", days=" + days +
                ", cars=" + cars +
                '}';
    }
}
