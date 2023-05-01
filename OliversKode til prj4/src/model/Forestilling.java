package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public boolean erPladsenLedig(int række, int nr, LocalDate dato) {
        boolean erLedig = true;
        if (!bestillinger.isEmpty()) {
            for (Bestilling b : bestillinger) {
                if (b.getDato().isEqual(dato)) {
                    // var pladser = b.getPladser();
                    for (Plads p : b.getPladser()) {
                        if (p.getRække() == række && p.getNr() == nr) {
                        erLedig = false;
                        }
                    }
                }
            }
        }
        return erLedig;
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int pladser = 0;
        for (Bestilling b : bestillinger) {
            if (b.getDato().isEqual(dato)) {
                pladser += b.getPladser().size();
            }
        }
        return pladser;
    }

    public LocalDate succesDato() {
        LocalDate dato = startDato;
        int flestPladser = 0;
        for (LocalDate d = startDato; d.isBefore(slutDato) || d.isEqual(slutDato); d = d.plusDays(1)) {
            if (antalBestiltePladserPåDag(d) > flestPladser) {
                dato = d;
            }
        }
        return dato;
    }

    @Override
    public String toString() {
        return "Forestilling: " + navn + "\n" +
                "Startdato   : " + startDato + "\n" +
                "Slutdato    : " + slutDato + "\n";
    }

}
