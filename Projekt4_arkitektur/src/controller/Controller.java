package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.getKunder().add(kunde);
        return kunde;
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde,
                                                       LocalDate dato, ArrayList<Plads> pladser) {

        LocalDate slutDato = forestilling.getSlutDato();
        LocalDate startDato = forestilling.getStartDato();

        Bestilling bestilling = null;

        if (dato.isAfter(startDato) && dato.isBefore(slutDato)) {
            boolean isPladserTaken = false;
            for (Plads plads : pladser) {
                if (!forestilling.erPladsLedig(plads.række(), plads.nr(), dato))
                    isPladserTaken = true;
            }

            if (!isPladserTaken) {
                bestilling = new Bestilling(dato, forestilling, kunde);

                for (Plads plads : pladser)
                    bestilling.addPlads(plads);
            }
        }
        if (bestilling != null)
            kunde.addBestilling(bestilling);
        return forestilling.addBestilling(bestilling);
    }


    public static ArrayList<Plads> bestiltePladserTilForestillingPådag(Kunde kunde, Forestilling forestilling, LocalDate dato) {
        return kunde.bestiltePladserTilForestillingPådag(forestilling, dato);
    }

    public static double samletPris(Bestilling bestilling) {
        return bestilling.samletPris();
    }

    public static LocalDate antalBestiltePladserPåDag(Forestilling forestilling) {
        return forestilling.succesDato();
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.getForestillinger().add(forestilling);
        return forestilling;
    }

    public static void createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.getPladser().add(plads);
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

}
