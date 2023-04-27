package opgaver.opgave1.model;

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

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalPladser = 0;
        for (Bestilling bestilling : bestillinger) {
            LocalDate beDato = bestilling.getDato();
            if (beDato.isEqual(dato))
                antalPladser += bestilling.getPladser().size();
        }
        return antalPladser;
    }

    public LocalDate succesDato() {
        int billetMax = 0;
        LocalDate maxDato = startDato;
        for (LocalDate dato = startDato;
             !dato.isAfter(slutDato);
             dato = dato.plusDays(1)) {
            if (antalBestiltePladserPåDag(dato) > billetMax) {
                billetMax = antalBestiltePladserPåDag(dato);
                maxDato = dato;
            }
        }
        return maxDato;
    }

    public boolean erPladsLedig(int række,int nr, LocalDate dato) {

        boolean erPladsLedig = true;

        for (int i = 0; erPladsLedig && i < bestillinger.size(); i++) {
            Bestilling bestilling = bestillinger.get(i);


            if (bestilling.getDato().isEqual(dato)) {
                ArrayList<Plads> pladser = bestilling.getPladser();

                for (int j = 0; erPladsLedig && j < pladser.size(); j++) {
                    Plads plads = bestilling.getPladser().get(i);

                    if (plads.getNr() == nr && plads.getRække() == række)
                        erPladsLedig = false;
                }
            }
        }
        return erPladsLedig;
    }

    public Bestilling addBestilling(Bestilling bestilling) {
        if (bestilling != null)
            bestillinger.add(bestilling);
        return bestilling;
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
