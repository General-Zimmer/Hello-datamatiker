package opgaver.opgave1.controller;

import javafx.collections.ObservableList;
import opgaver.opgave1.model.*;
import opgaver.opgave1.storage.Storage;

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

        if (forestilling.getStartDato().isAfter(dato) && forestilling.getSlutDato().isBefore(dato)) return null;

        for (Plads plads : pladser) {
            if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato))
                return null;
        }

        Bestilling bestilling = new Bestilling(dato, forestilling, kunde);

        for (Plads plads : pladser)
            bestilling.addPlads(plads);

        return bestilling;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.getForestillinger().add(forestilling);
        return forestilling;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.getPladser().add(plads);
        return plads;
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

}
