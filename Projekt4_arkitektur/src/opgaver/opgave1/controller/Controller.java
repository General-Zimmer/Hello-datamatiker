package opgaver.opgave1.controller;

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


}
