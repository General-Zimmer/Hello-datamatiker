package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    public static Bane createBane(Kategori kategori, int nummer, boolean inde, LocalTime førstetid, LocalTime sidsteTid) {
        return Storage.addBane(new Bane(kategori, nummer, inde, førstetid, sidsteTid));
    }

    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble) {
        return Storage.addKategori(new Kategori(navn, prisKrSingle, prisKrDouble));
    }

    public static Spiller createSpiller(String navn, String uddannelse) {
        return Storage.addSpiller(new Spiller(navn, uddannelse));
    }

    public static Booking createBooking(Spiller spiller, LocalDate dato, LocalTime tid, boolean single, Bane bane) {
        Booking booking = new Booking(spiller, dato, tid, single, bane);
        spiller.addBookings(booking);
        bane.addBookings(booking);
        return booking;
    }

    public static int samletDoubleTid(String uddannelse, Kategori kategori) {
        int samletDoubleTid = 0;

        for (Spiller spiller : Storage.getSpillere()) {
            if (!uddannelse.equals(spiller.getUddannelse())) {

                for (Booking booking : spiller.getBookings()) {
                    if (!booking.isSingle()) {

                        samletDoubleTid += booking.getBane().getKategori().equals(kategori) ? 1 : 0;

                    }
                }

            }
        }

        return samletDoubleTid;
    }

    public static Bane findLedigBane(LocalDate dato, LocalTime  tid, Kategori kategori) {
        ArrayList<Bane> baner = Storage.getBaner();
        Bane ledigBane = null;
        int i = 0;


        while(i < baner.size() && ledigBane == null) {
            Bane bane = baner.get(i);

            if (bane.getKategori().equals(kategori))
                if (bane.tidLedig(dato, tid))
                    ledigBane = bane;

            i++;
        }
        return ledigBane;
    }

    public static void alleBookings(String filePath) {
        try (PrintWriter write = new PrintWriter(filePath)) {
            ArrayList<Bane> baner = Storage.getBaner();

            for (Bane bane : baner) {
                for (Booking booking : bane.getBookings())
                    write.println(booking.toString());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fil ikke fundet. Husk at ændre filePath med din pc's absolute path inde i App");
        }
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }

    public static ArrayList<Spiller> getSpillere() {
        return Storage.getSpillere();
    }


}
