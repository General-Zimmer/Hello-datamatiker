package opgaver.opgave3;

public class Car {
    private String no;
    private String year;
    private int pricePerDay;

    public Car(String no, String year) {

    }

    public String getYear() {
        return year;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "no='" + no + '\'' +
                ", year='" + year + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
