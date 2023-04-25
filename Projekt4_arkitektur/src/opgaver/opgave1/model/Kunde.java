package opgaver.opgave1.model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "navn='" + navn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", bestillinger=" + bestillinger +
                '}';
    }
}
