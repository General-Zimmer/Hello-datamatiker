import Controller.Controller;
import Model.Konto;
import Model.KontoType;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som beskytter unge ved ikke at tillade at der hæves på en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype);

		Controller.foretagTransaktion(k1, 100);
		Controller.foretagTransaktion(k1, 200);
		Controller.foretagTransaktion(k1, -400);

		Controller.foretagTransaktion(k1, -200); // giver exception

		Controller.foretagTransaktion(k1, 1000);

		Controller.lukKonto(k1);

		Controller.foretagTransaktion(k1, 1000000000);

	}
}
