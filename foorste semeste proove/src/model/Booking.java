package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private Bane bane;
    private Spiller spiller;

    private LocalDate dato;
    private LocalTime tid;
    private boolean single;

    public Booking(Spiller spiller, LocalDate dato, LocalTime tid, boolean single, Bane bane) {
        this.spiller = spiller;
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.bane = bane;
    }


    @Override
    public String toString() {
        return "Bane nr: " + bane.getNummer() +
                ", dag: " + dato.toString() + ". " +
                tid.toString() +
                ", spil: " + (this.single ? "single" : "double") +
                ", spiller: " + spiller.getNavn();
    }

    public Bane getBane() {
        return bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setBane(Bane bane) {
        this.bane = bane;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }
}
