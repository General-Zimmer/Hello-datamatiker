package opgaver.opgave1.gui;

import opgaver.opgave1.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import opgaver.opgave1.model.Forestilling;
import opgaver.opgave1.model.Kunde;
import opgaver.opgave1.storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater Bestilling");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final ListView lvwForestillinger = new ListView<>();
    private final ListView lvwKunder = new ListView<>();
    private final ListView lvwPladser = new ListView<>();
    private final TextField txfName = new TextField();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();
    private final TextField txfPladsDato = new TextField();
    private final Button btnOpretForestilling = new Button("Opret Forestilling");
    private final Button btnOpretKunde = new Button("Opret Kunde");
    private final Button btnOpretBestilling = new Button("Opret bestilling");
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final Alert success = new Alert(Alert.AlertType.CONFIRMATION);


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger,0,0);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder,3,0);

        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser,6,0);

        pane.add(lvwForestillinger,0,1, 2,1);
        pane.add(lvwKunder,3,1,2,1);
        pane.add(lvwPladser,6,1,2,1);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0,2);
        pane.add(txfName,1,2);

        Label lblStartDato = new Label("StartDato");
        pane.add(lblStartDato, 0,3);
        pane.add(txfStartDato,1,3);

        Label lblSlutDato = new Label("SlutDato");
        pane.add(lblSlutDato, 0,4);
        pane.add(txfSlutDato,1,4);

        // Tilføjer Opret forestilling Knap
        pane.add(btnOpretForestilling,1,5);

        Label lblKundeNavn = new Label("Kunde Navn");
        pane.add(lblKundeNavn, 3,2);
        pane.add(txfKundeNavn,4,2);

        Label lblKundeMobil = new Label("Kunde Mobil");
        pane.add(lblKundeMobil,3,3);
        pane.add(txfKundeMobil,4,3);

        Label lblPladsDato = new Label("Dato");
        pane.add(lblPladsDato, 6,2);
        pane.add(txfPladsDato,7,2);

        // Tilføjer Opret kunde Knap
        pane.add(btnOpretKunde,4,4);

        pane.add(btnOpretBestilling, 7,3);

        this.initItems();
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        lvwKunder.getItems().setAll(Controller.getKunder());

        btnOpretKunde.setOnAction(event -> this.opretKundeOnAction());
        btnOpretForestilling.setOnAction(event -> this.opretForestillingOnAction());
    }

    public void initItems() {
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8,20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023,9,1), LocalDate.of(2023,9,10));
        Controller.createForestilling("Chess", LocalDate.of(2023,8,21), LocalDate.of(2023,8,30));

        Controller.createKunde("Anders", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");
    }

    public void opretForestillingOnAction() {
        // Opretter dateTimeFormatter til at lave String om til LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        boolean validDate = true;
        String name = txfName.getText().trim();
        String StartDato = txfStartDato.getText().trim();
        String SlutDato = txfSlutDato.getText().trim();
        LocalDate startDate = null;
        LocalDate slutDate = null;


        if (SlutDato.split("/").length == 3 && StartDato.split("/").length == 3) {
            try {
                startDate = LocalDate.parse(StartDato, formatter);
                slutDate = LocalDate.parse(SlutDato, formatter);
            }
            catch (DateTimeParseException e) {
                System.out.println("HAHA, fuck yoooooou");
            }

        }

        if (name.length() < 1 || StartDato.length() < 1 || SlutDato.length() < 1) {
            alert.setTitle("Tilføj Forestilling");
            alert.setHeaderText("Et er dine felter er tomme");
            alert.setContentText("Udfyld venligst et navn, start og slut-dato");
            alert.show();
        } else if(startDate != null) {
            if (slutDate.isAfter(startDate)) {
                Controller.createForestilling(name, startDate, slutDate);
                lvwForestillinger.getItems().setAll(Controller.getForestillinger());
                txfName.clear();
                txfStartDato.clear();
                txfSlutDato.clear();
            } else {
                alert.setTitle("Tilføj Forestilling");
                alert.setHeaderText("Forkert Dato");
                alert.setContentText("Du har indtastet en slutdato der er før din startdato");
                alert.show();
            }
        } else {
            alert.setTitle("Tilføj Forestilling");
            alert.setHeaderText("Du har indtastet en ugyldig dato");
            alert.setContentText("Datoer skal skrives med følgende format: dd/MM/yyyy - Husk at tjekke om datoen findes");
            alert.show();
        }
    }

    public void opretKundeOnAction() {
        String kundeNavn = txfKundeNavn.getText().trim();
        String kundeMobil = txfKundeMobil.getText().trim();
        if (kundeNavn.length() < 1 || kundeMobil.length() < 1) {
            alert.setTitle("Tilføj Forestilling");
            alert.setHeaderText("Et er dine felter er tomme");
            alert.setContentText("Udfyld venligst et navn og et mobil nummer");
            alert.show();
        } else {
            Controller.createKunde(kundeNavn,kundeMobil);
            lvwKunder.getItems().setAll(Controller.getKunder());
            txfKundeNavn.clear();
            txfKundeMobil.clear();
        }

    }



}

