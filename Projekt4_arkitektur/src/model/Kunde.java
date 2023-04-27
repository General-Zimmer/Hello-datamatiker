package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Kunde {
    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladser = new ArrayList<>();
        for (Bestilling bestilling : forestilling.getBestillinger()) {
            if (bestilling.getDato().isEqual(dato) && this.equals(bestilling.getKunde()))
                pladser.addAll(bestilling.getPladser());
        }
        return pladser;
    }

    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    @Override
    public String toString() {
        return  navn +  " (" + mobil + ")";
    }

    public String toStringv2() {
        return "Kunde{" +
                "navn='" + navn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", bestillinger=" + bestillinger +
                '}';
    }
}
