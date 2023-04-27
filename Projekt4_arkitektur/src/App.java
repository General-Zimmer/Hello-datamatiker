import controller.Controller;
import gui.Gui;
import javafx.application.Application;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    public static void initStorage() {
        LocalDate date = LocalDate.of(2023, 8, 21);
        Forestilling evita = Controller.createForestilling("Evita", LocalDate.of(2023,8,10), LocalDate.of(2023, 8,20));
        Forestilling lykke = Controller.createForestilling("Lykke Per", LocalDate.of(2023,9,1), LocalDate.of(2023,9,10));
        Forestilling chess = Controller.createForestilling("Chess", date, LocalDate.of(2023,8,30));

        Kunde anders = Controller.createKunde("Anders", "11223344");
        Kunde peter = Controller.createKunde("Peter Jensen", "12345678");
        Kunde mads = Controller.createKunde("Niels Madsen", "12341234");

        opretPladser();
        // Tester nogle metoder.

        // Sætter test op
        // Mads
        ArrayList<Plads> madsPladser = new ArrayList<>(Controller.getPladser().subList(100, 101));
        Controller.opretBestillingMedPladser(chess, mads, date.plusDays(1), madsPladser); // (2023, 8, 22)

        // peter
        ArrayList<Plads> peterPladser = new ArrayList<>(Controller.getPladser().subList(102, 104));
        Controller.opretBestillingMedPladser(chess, peter, date.plusDays(3), peterPladser); // (2023, 8, 24)


        // Anders
        ArrayList<Plads> andersPladser = new ArrayList<>(Controller.getPladser().subList(105, 110));
        Controller.opretBestillingMedPladser(chess, anders, date.plusDays(2), andersPladser); // (2023, 8, 23)

        testPrint();

        LocalDate success = Controller.antalBestiltePladserPåDag(chess);

        System.out.println("Dagen med de fleste pladser i Chess forestillingen er: " + success);

        System.out.println("------------------------------");
        System.out.println("Pladser som Anders har bestilt:");
        System.out.println("------------------------------");
        for (Plads plads : Controller.bestiltePladserTilForestillingPådag(anders, chess, date.plusDays(2)))
            System.out.print(plads.toStringv2() + "\n");

    }

    public static void testPrint() {
        ArrayList<Forestilling> forestillinger = Controller.getForestillinger();
        System.out.println("Forestillinger:");
        System.out.println("------------------------------");
        for (Forestilling forestilling : forestillinger)
            System.out.println(forestilling.toStringv2());

        System.out.println("------------------------------");
        System.out.println("Kunder:");
        System.out.println("------------------------------");
        ArrayList<Kunde> kunder = Storage.getKunder();
        for (Kunde kunde : kunder)
            System.out.println(kunde.toStringv2());

        System.out.println("------------------------------");
        System.out.println("Pladser:");
        System.out.println("------------------------------");
        ArrayList<Plads> pladser = Storage.getPladser();


        for (Plads plads : pladser) {

            System.out.printf(plads.toStringv2() + "%3s", " ");
            if (plads.nr() == 20) {
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }

    private static void opretPladser() {
        int gul = 500;
        int grøn = 450;
        int blå = 400;
        for (int række = 1; række < 16; række++) {
            for (int nr = 1; nr < 21; nr++) {
                if (række < 6 && (nr < 2 || nr > 18)) {
                    Controller.createPlads(række, nr, grøn, PladsType.STANDARD);
                }
                else if (række < 6) {
                    Controller.createPlads(række,nr,gul,PladsType.STANDARD);
                }
                else if (række == 10 && (nr > 7 && nr < 13)) {
                    Controller.createPlads(række, nr, grøn, PladsType.KØRESTOL);
                } else if (række < 11 && (nr < 2 || nr > 18)) {

                    Controller.createPlads(række,nr,blå,PladsType.STANDARD);

                } else {

                    if (række == 11 && (nr > 7 && nr < 13)) {
                        Controller.createPlads(række,nr,blå,PladsType.LANGEBEN);
                    } else {
                        Controller.createPlads(række,nr,blå,PladsType.STANDARD);
                    }

                }
            }
        }
    }

}
