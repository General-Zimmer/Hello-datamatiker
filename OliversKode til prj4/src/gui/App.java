package gui;

import controller.Controller;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        //testPrint();
        ForestillingGui.launch(ForestillingGui.class);
    }

    public static void initStorage() {
        Forestilling evita = Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Forestilling lykkePer = Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Forestilling chess = Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Kunde anders = Controller.createKunde("Anders Hansen", "11223344");
        Kunde peter = Controller.createKunde("Peter Jensen", "12345678");
        Kunde niels = Controller.createKunde("Niels Madsen", "12341234");



        for (int række = 1; række <= 15; række++) {
            for (int nr = 1; nr <= 20; nr++) {
                // For de gule pladser til 500,-
                if (række < 6 && nr > 2 && nr < 19) {
                    Plads plads = Controller.createPlads(række, nr, 500, Plads.PladsType.STANDARD);
                }
                // For de grønne pladser til 450,-
                if ((række < 6 && (nr < 3 || nr > 18)) || (række > 5 && række < 11 && nr > 2 && nr < 19)) {
                    Plads plads = Controller.createPlads(række, nr, 450, Plads.PladsType.STANDARD);
                }
                // For de blå pladser til 400,-
                if ((række > 5 && (nr < 3 || nr > 18)) || række > 10) {
                    Plads plads = Controller.createPlads(række, nr, 400, Plads.PladsType.STANDARD);
                }
            }
        }

        // Ændre pladstype på de nødvendige pladser
        for (Plads p : Controller.getPladser()) {
            if (p.getRække() == 10 && p.getNr() > 7 && p.getNr() < 13) {
                p.setPladsType(Plads.PladsType.KØRESTOL);
            }
            if (p.getRække() == 11 && p.getNr() > 7 && p.getNr() < 13) {
                p.setPladsType(Plads.PladsType.LANGEBEN);
            }
        }

        // TEST OPGAVE 7
        ArrayList<Plads> pladsTest = new ArrayList<>();
        pladsTest.add(Controller.getPladser().get(1));
        pladsTest.add(Controller.getPladser().get(103));
        pladsTest.add(Controller.getPladser().get(18));
        Bestilling b1 = Controller.opretBestillingMedPladser(evita, anders, LocalDate.of(2023, 8, 13), pladsTest);
        System.out.println(b1.samletPris());
        System.out.println(evita.antalBestiltePladserPåDag(LocalDate.of(2023, 8, 13)));
        System.out.println(evita.succesDato());
        System.out.println(anders.bestiltePladserTilForestillingPåDag(evita, LocalDate.of(2023, 8, 13)).toString());
    }

    public static void testPrint() {
        for (Forestilling forestilling : Storage.getForestillinger()) {
            System.out.println(forestilling.toString());
        }
        for (Kunde kunde : Storage.getKunder()) {
            System.out.println(kunde.toString());
        }
        System.out.println("Pladser:");
        for (Plads plads : Storage.getPladser()) {
            if (plads.getNr() == 20) {
                System.out.print(plads.toString() + " \n");
            } else {
            System.out.print(plads.toString() + " ");
            }
        }

        System.out.println();
        System.out.println(Storage.getPladser().size());
    }
}
