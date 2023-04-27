package util;

import javafx.scene.control.Alert;

public class Util {

    public static void datoUgyldig(Alert alert, String title) {
        alert.setTitle(title);
        alert.setHeaderText("Du har indtastet en ugyldig dato");
        alert.setContentText("Datoer skal skrives med følgende format: dd/MM/yyyy - Husk at tjekke om datoen findes");
        alert.show();
    }

    public static void tommeFelter(Alert alert, String title) {
        alert.setTitle(title);
        alert.setHeaderText("Et eller flere af dine felter er tomme");
        alert.setContentText("Udfyld venligst alle felter");
        alert.show();
    }
}
