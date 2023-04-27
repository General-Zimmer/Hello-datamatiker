package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Bestilling {
    private LocalDate dato;
    private final Forestilling forestilling;
    private Kunde kunde; // not nullable
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.dato = dato;
        this.forestilling = forestilling;
        this.kunde = kunde;
    }

    public double samletPris() {

        double pris = 0;
        for (Plads plads : pladser)
            pris += plads.pris();

        return pris;
    }

    public void addPlads(Plads plads) {
        pladser.add(plads);
    }
    public LocalDate getDato() {
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }
}
