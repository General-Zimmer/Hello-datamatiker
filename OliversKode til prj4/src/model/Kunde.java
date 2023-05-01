package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> bestiltePladser = new ArrayList<>();
        for (Bestilling b : bestillinger) {
            if (b.getForestilling().equals(forestilling) && b.getDato().isEqual(dato)) {
                bestiltePladser.addAll(b.getPladser());
            }
        }

        return bestiltePladser;
    }
    @Override
    public String toString() {
        return  "Navn        : " + navn + "\n" +
                "Mobilnr.    : " + mobil + "\n";
    }
}
