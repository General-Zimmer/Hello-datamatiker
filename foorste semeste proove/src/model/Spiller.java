package model;

import java.util.ArrayList;

public class Spiller {

    private final ArrayList<Booking> bookings = new ArrayList<>();
    private String navn;
    private String uddannelse;


    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    private double samletPris(Kategori kategori) {
        double samletPris = 0;

        for (Booking booking : bookings) {
            Kategori baneKategori = booking.getBane().getKategori();
            if (baneKategori.equals(kategori)) {
                samletPris += booking.isSingle() ? baneKategori.getPrisKrSingle() : baneKategori.getPrisKrDouble();
            }
        }

        return samletPris;
    }


    @Override
    public String toString() {
        return navn + " (" + uddannelse + ")";
    }

    public void addBookings(Booking booking) {
        bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }
}
