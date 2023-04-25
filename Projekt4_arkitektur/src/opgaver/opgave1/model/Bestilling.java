package opgaver.opgave1.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private final Forestilling forestilling;
    private Kunde kunde;
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.dato = dato;
        this.forestilling = forestilling;
        this.kunde = kunde;
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
        return pladser;
    }
}
