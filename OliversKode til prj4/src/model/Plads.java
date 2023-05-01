package model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public enum PladsType {
        STANDARD,
        LANGEBEN,
        KØRESTOL
    }

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    public void setPladsType(PladsType pladsType) {
        this.pladsType = pladsType;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        String s = String.format("Rk %2d nr %2d", række, nr);
        s += " (kr. " + pris + " " + pladsType + ")\n";

        return s;
    }
}
