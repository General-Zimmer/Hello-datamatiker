package opgaver.opgave1.model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }



    @Override
    public String toString() {

        return String.format("Rk: %3d, nr: %3s, ( %3d, kr  %s  )", række, nr, pris, pladsType);
    }

    public String toStringv2() {
        return String.format("række: %3d, nr: %3s, pris: %3d, plads type: %s ", række, nr, pris, pladsType);
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

    public PladsType getPladsType() {
        return pladsType;
    }
}
