package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ForestillingGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Listview felter 2
    private final ListView<Forestilling> lvwForestilling = new ListView<>();
    private final ListView<Kunde> lvwKunde = new ListView<>();
    private final ListView<Plads> lvwPlads = new ListView<>();

    // Textfield felter 5
    private final TextField txfNavn = new TextField();
    private final TextField txfStartdato = new TextField();
    private final TextField txfSlutdato = new TextField();
    private final TextField txfKundenavn = new TextField();
    private final TextField txfKundemobil = new TextField();
    private final TextField txfPladsDato = new TextField();

    // Button felter 2
    private final Button btnOpretForestilling = new Button("Opret forestilling");
    private final Button btnOpretKunde = new Button("Opret kunde");
    private final Button btnOpretBestilling = new Button("Opret bestilling");

    private Label lblError = new Label();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // -------------------------------------------------------------------------

        // FORESTILLINGER
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);
        lblForestillinger.setStyle("-fx-font-weight: bold");
        pane.add(lvwForestilling, 0, 1, 2, 1);
        lvwForestilling.setPrefWidth(200);
        lvwForestilling.setPrefHeight(200);
        lvwForestilling.getItems().setAll(Storage.getForestillinger());

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 2);
        pane.add(txfNavn, 1, 2);
        txfNavn.setPromptText("eks. \"Grease\"");

        Label lblStartdato = new Label("Start dato:");
        pane.add(lblStartdato, 0, 3);
        pane.add(txfStartdato, 1, 3);
        txfStartdato.setPromptText("YYYY-MM-DD");

        Label lblSlutdato = new Label("Slut dato:");
        pane.add(lblSlutdato, 0, 4);
        pane.add(txfSlutdato, 1, 4);
        txfSlutdato.setPromptText("YYYY-MM-DD");

        pane.add(btnOpretForestilling, 1, 5);
        btnOpretForestilling.setOnAction(event -> this.opretForestilling());

        // KUNDER
        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 2, 0);
        lblKunder.setStyle("-fx-font-weight: bold");
        pane.add(lvwKunde, 2, 1, 2, 1);
        lvwKunde.setPrefWidth(200);
        lvwKunde.setPrefHeight(200);
        lvwKunde.getItems().setAll(Storage.getKunder());

        Label lblKundeNavn = new Label("Kunde navn: ");
        pane.add(lblKundeNavn, 2, 2);
        pane.add(txfKundenavn, 3, 2);
        txfKundenavn.setPromptText("eks. \"Oliver Buus\" ");

        Label lblKundemobil = new Label("Kunde mobil: ");
        pane.add(lblKundemobil, 2, 3);
        pane.add(txfKundemobil, 3, 3);
        txfKundemobil.setPromptText("eks. \"12345678\"");

        pane.add(btnOpretKunde, 3, 5);
        btnOpretKunde.setOnAction(event -> this.opretKunde());

        // PLADS
        Label lblPlads = new Label("Plads");
        pane.add(lblPlads, 4, 0);
        lblPlads.setStyle("-fx-font-weight: bold");
        pane.add(lvwPlads, 4, 1, 2, 1);
        lvwPlads.setPrefWidth(200);
        lvwPlads.setPrefHeight(200);
        lvwPlads.getItems().setAll(Storage.getPladser());
        lvwPlads.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblPladsDato = new Label("Dato:");
        pane.add(lblPladsDato, 4, 2);
        pane.add(txfPladsDato, 5, 2);
        txfPladsDato.setPromptText("YYYY-MM-DD");

        pane.add(btnOpretBestilling, 5, 5);
        btnOpretBestilling.setOnAction(event -> this.opretBestilling());

        // ERROR
        pane.add(lblError, 0, 6, 4, 1);
        GridPane.setHalignment(lblError, HPos.CENTER);
        lblError.setStyle("-fx-text-fill: red");

    }

    private void opretForestilling() {
        String navn = txfNavn.getText().trim();
        if (navn.length() == 0) {
            lblError.setText("Forestillingsnavn er tom");
            return;
        }

        if (!erDatoValid(txfStartdato.getText().trim())) {
            lblError.setText("Start dato er indtastet forkert");
            return;
        }

        if (!erDatoValid(txfSlutdato.getText().trim())) {
            lblError.setText("Slut dato er indtastet forkert");
            return;
        }

        LocalDate startDato = LocalDate.parse(txfStartdato.getText().trim());
        LocalDate slutDato = LocalDate.parse(txfSlutdato.getText().trim());

        // Tjekker om slutdato ligger efter startdato
        if (slutDato.isBefore(startDato)) {
            lblError.setText("Slut dato kan ikke være sat før start dato");
            return;
        }

        Forestilling nyForestilling = Controller.createForestilling(navn, startDato, slutDato);
        lvwForestilling.getItems().add(nyForestilling);
        Storage.storeForestilling(nyForestilling);

        txfNavn.clear();
        txfStartdato.clear();
        txfSlutdato.clear();

    }

    private void opretKunde() {
        String navn = txfKundenavn.getText().trim();
        String mobilnr = txfKundemobil.getText().trim();
        if (navn.length() == 0) {
            lblError.setText("Kundenavn mangler");
            return;
        }

        if (!erMobilnrValid(txfKundemobil.getText().trim())) {
            lblError.setText("Mobilnummer er ugyligt");
            return;
        }

        Kunde nyKunde = Controller.createKunde(navn, mobilnr);
        lvwKunde.getItems().add(nyKunde);
        Storage.storeKunde(nyKunde);

        txfKundenavn.clear();
        txfKundemobil.clear();
        lblError.setText("");
    }

    private void opretBestilling() {
        if (!erDatoValid(txfPladsDato.getText().trim())) {
            lblError.setText("Dato er indtastet forkert");
            return;
        }

        Forestilling forestilling = lvwForestilling.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunde.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfPladsDato.getText().trim());
        ArrayList<Plads> pladser = new ArrayList<>(lvwPlads.getSelectionModel().getSelectedItems());

        Bestilling nyBestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);


        // Dialogbox
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Status");
        dialog.setHeaderText("Status på bestilling");
        if (nyBestilling != null) {
            dialog.setContentText("Bestillingen var succesfuld\n" +
                    nyBestilling.getPladser() + "\n" +
                    "Samlet pris:" + nyBestilling.samletPris()
                    );
        } else {
        dialog.setContentText("Bestillingen gik ikke igennem\n" +
                "Enten var pladserne ikke ledige, ellers var forestillingen ikke på denne dato.");
        }
        dialog.show();
        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());
    }

    private boolean erDatoValid(String dato) {
        // Tjekker om datoen er valid
        boolean erValid = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        try {
            formatter.parse(dato);
        } catch (DateTimeParseException e) {
            erValid = false;
        }
        return erValid;
    }

    private boolean erMobilnrValid(String mobilnr) {
        // Tjekker om en string er et 8-cifret tal
        boolean erValid = true;
        if (!mobilnr.matches("\\d+") || mobilnr.length() != 8) {
            erValid = false;
        }
        return erValid;
    }
}
