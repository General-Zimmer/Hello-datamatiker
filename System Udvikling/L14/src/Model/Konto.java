package Model;

import java.util.ArrayList;

public class Konto {

	private final int nr;

	private final ArrayList<Transaktion> transaktioner;

	private KontoType kontoType;

	private Tilstand tilstand;

	public Konto(KontoType kontoType, int nr) {

		this.kontoType = kontoType;
		this.nr = nr;
		this.tilstand = Tilstand.AABEN;
		transaktioner = new ArrayList<>();
	}

	public int getNr() {
		return this.nr;
	}

	public Transaktion createTransaktion(int beløb) {
		Transaktion transaktion = null;
		if (tilstand == Tilstand.LUKKET)
			throw new RuntimeException("Du forsøger at hæve/tilføje på en lukket konto!");
		else if (tilstand != Tilstand.OVERTRUKKET || beløb > 0) {
			transaktion = new Transaktion(beløb);
			transaktioner.add(transaktion);
			System.out.println(beregnSaldo());
			if (beregnSaldo() < 0) {
				tilstand = Tilstand.OVERTRUKKET;
			} else {
				tilstand = Tilstand.AABEN;
			}
		} else
			throw new RuntimeException("Du forsøger at hæve på en overtrukket konto!");

		return transaktion;
	}

	public int beregnSaldo() {
		int saldo = 0;
		for (Transaktion transaktion : transaktioner) {
			saldo += transaktion.getBeløb();
		}
		return saldo;

	}

	public void lukKonto() {
		this.tilstand = Tilstand.LUKKET;
	}

	@Override
	public String toString() {
		return "Saldo konto nr. " + getNr() + " er " + beregnSaldo();
	}
}
