package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {

    private Kategori kategori;
    private final ArrayList<Booking> bookings = new ArrayList<>();
    private int nummer;
    private boolean inde;
    private LocalTime førstetid;
    private LocalTime sidsteTid;

    public Bane(Kategori kategori, int nummer, boolean inde, LocalTime førstetid, LocalTime sidsteTid) {
        this.kategori = kategori;
        this.nummer = nummer;
        this.inde = inde;
        this.førstetid = førstetid;
        this.sidsteTid = sidsteTid;
    }

    public int bookedeTimerPåDato(LocalDate dato) {
        int antalTimerPåDato = 0;
        for (Booking booking : bookings) {
            if (booking.getDato().equals(dato)) {
                antalTimerPåDato++;
            }
        }
        return antalTimerPåDato;
    }

    /**
     * Vil give dig en 24 lang array med tidspunkter for start af alle dens bookings
     * Note: værdier af 0 kan ignoraos
     * @return
     */
    public int[] AntalBookningerPrTime() {
        int[] AntalBookningerPrTime = new int[24];

        for (Booking booking : bookings) {
            LocalTime tid = booking.getTid();
            AntalBookningerPrTime[tid.getHour()]++;
        }
        return AntalBookningerPrTime;
    }

    public boolean tidLedig(LocalDate dato, LocalTime tid) {
        boolean erLedig = true;
        int i = 0;
        while(i < bookings.size() && erLedig) {
            LocalTime bookTid = bookings.get(i).getTid();
            LocalDate bookDato = bookings.get(i).getDato();
            if (bookTid.equals(tid) && bookDato.equals(dato))
                erLedig = false;

            i++;
        }

        return erLedig;
    }

    @Override
    public String toString() {
        return "Nr. " + nummer + " " + (inde ? "inde" : "ude") +
                " ("+ this.førstetid.toString()+ " -> " + sidsteTid.toString() +
                "), " + kategori.getNavn();
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void addBookings(Booking booking) {
        bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørstetid() {
        return førstetid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }
}
