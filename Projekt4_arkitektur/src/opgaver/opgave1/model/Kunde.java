package opgaver.opgave1.model;

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

    public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladser = new ArrayList<>();
        for (Bestilling bestilling : forestilling.getBestillinger()) {
            if (bestilling.getDato().isEqual(dato) && bestilling.getKunde().equals(this) && forestilling.equals(bestilling.getForestilling()))
                pladser.addAll(bestilling.getPladser());
        }
        return pladser;
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
