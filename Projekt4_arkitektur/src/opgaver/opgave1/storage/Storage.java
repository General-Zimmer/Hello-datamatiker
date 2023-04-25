package opgaver.opgave1.storage;

import opgaver.opgave1.model.Forestilling;
import opgaver.opgave1.model.Kunde;
import opgaver.opgave1.model.Plads;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Kunde> kunder = new ArrayList<>();
    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();

    public static ArrayList<Kunde> getKunder() {
        return kunder;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return forestillinger;
    }

    public static ArrayList<Plads> getPladser() {
        return pladser;
    }
}
