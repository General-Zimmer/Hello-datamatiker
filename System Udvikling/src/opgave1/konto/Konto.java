package opgave1.konto;

@SuppressWarnings("unused")
public class Konto {

    private int nr;
    private int saldo;
    private String kontoType;
    private String status;

    public Konto(int nr, String kontoType) {
        this.nr = nr;
        this.kontoType = kontoType;
        this.saldo = 0;
        this.status = "open";
    }

    public void putInSaldo(int amount) {
        if (!status.equalsIgnoreCase("closed"))
            saldo += amount;
    }

    public void removeFromSaldo(int amount) {
        if (!status.equalsIgnoreCase("closed") && (saldo-amount) > 0)
            saldo -= amount;
    }

    public int getNr() {
        return nr;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getKontoType() {
        return kontoType;
    }

    public void setKontoType(String kontoType) {
        this.kontoType = kontoType;
    }

    public String getStatus() {
        return status;
    }

    public void closeKonto() {
        this.status = "closed";
    }
}
