package storage;

import model.Bane;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Spiller> spillere = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Kategori> kategorier = new ArrayList<>();

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }
    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }
    public static ArrayList<Kategori> getKategorier() {
        return new ArrayList<>(kategorier);
    }

    public static Spiller addSpiller(Spiller spiller) {
        spillere.add(spiller);
        return spiller;
    }
    public static Bane addBane(Bane bane) {
        baner.add(bane);
        return bane;
    }
    public static Kategori addKategori(Kategori kategori) {
        kategorier.add(kategori);
        return kategori;
    }

}
