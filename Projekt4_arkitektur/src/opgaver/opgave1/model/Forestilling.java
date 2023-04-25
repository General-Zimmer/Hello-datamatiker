package opgaver.opgave1.model;

import opgaver.opgave1.storage.Storage;

import java.time.LocalDate;
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


    public boolean erPladsLedig(int række,int nr, LocalDate dato) {

        for (Bestilling bestilling : bestillinger)  {

            if (bestilling.getDato().isEqual(dato))
                for (Plads plads : bestilling.getPladser())
                    if (plads.getNr() == nr && plads.getRække() == række)
                        return false;

        }

        return true;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }

    @Override
    public String toString() {
        return  navn +
                "(fra " + startDato +
                " til " + slutDato + ")";
    }

    public String toStringv2() {
        return "Forestilling{" +
                "navn='" + navn + '\'' +
                ", startDato=" + startDato +
                ", slutDato=" + slutDato +
                ", bestillinger=" + bestillinger +
                '}';
    }
}
