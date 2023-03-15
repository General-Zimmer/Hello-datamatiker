package L06.opgave2.KodEnDesignetKlasse;

import java.util.UUID;

@SuppressWarnings("unused")
public class Spiller {
    private String navn;
    private String hold;
    private int alder;
    private int goal;
    private String role;
    private int nummer;
    private UUID spilleLicense;

    public Spiller(String navn, String hold, int alder, int goal, String role, int nummer, UUID spilleLicense) {
        this.navn = navn;
        this.hold = hold;
        this.alder = alder;
        this.goal = goal;
        this.role = role;
        this.nummer = nummer;
        this.spilleLicense = spilleLicense;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void birthday() {
        this.alder++;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public UUID getSpilleLicense() {
        return spilleLicense;
    }

    public void setSpilleLicense(UUID spilleLicense) {
        this.spilleLicense = spilleLicense;
    }
}
