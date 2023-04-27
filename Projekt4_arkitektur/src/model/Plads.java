package model;

public record Plads(int række, int nr, int pris, PladsType pladsType) {


    @Override
    public String toString() {

        return String.format("Rk: %3d, nr: %3s, ( %3d, kr  %s  )", række, nr, pris, pladsType);
    }

    public String toStringv2() {
        return String.format("række: %3d, nr: %3s, pris: %3d, plads type: %s ", række, nr, pris, pladsType);
    }
}
