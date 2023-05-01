package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private final Forestilling forestilling;
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling, ArrayList<Plads> pladser) {
        this.dato = dato;
        this.kunde = kunde;
        this.forestilling = forestilling;
        this.pladser.addAll(pladser);
    }

    public LocalDate getDato() {
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public ArrayList<Plads> getPladser() {
        return pladser;
    }

    public int samletPris() {
        int samletPris = 0;
        for (Plads p : pladser) {
            samletPris += p.getPris();
        }
        return samletPris;
    }
}
