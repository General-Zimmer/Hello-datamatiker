package controller;

import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.storeForestilling(forestilling);
        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.storeKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, Plads.PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.storePlads(plads);
        return plads;
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean fortsæt = true;

        // Tjek om forestillingen vises på den dato (hvis ikke returneres null)
        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())) {
            fortsæt = false;
        }

        // Tjek om pladserne er ledige (hvis ikke returneres null)
        if (fortsæt) {
            for (Plads plads : pladser) {
                if (!forestilling.erPladsenLedig(plads.getRække(), plads.getNr(), dato)){
                    fortsæt = false;
                }
            }
        }

        // Opretter en bestilling
        if(fortsæt){
            bestilling = new Bestilling(dato, kunde, forestilling, pladser);
            kunde.addBestilling(bestilling);
            forestilling.addBestilling(bestilling);
        }

        return bestilling;
    }
}
