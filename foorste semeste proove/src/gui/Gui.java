package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Zimmer's Gui med super eksamne logik bagved");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        double width = 250;
        double height = 160;


        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // Første row

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 0);

        ListView<Bane> lvBaner = new ListView<>();
        pane.add(lvBaner, 0, 1, 1, 1);
        lvBaner.setPrefWidth(width);
        lvBaner.setPrefHeight(height);
        lvBaner.getItems().addAll(Controller.getBaner());


        Label lblbookingAntal = new Label("Antal bookinger på banen");
        pane.add(lblbookingAntal, 0, 2);

        TextArea txaBookingAntal = new TextArea();
        pane.add(txaBookingAntal, 0, 3, 1, 4);
        txaBookingAntal.setPrefHeight(height);
        txaBookingAntal.setPrefWidth(width);


        // Anden row

        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere, 1, 0);

        ListView<Spiller> lvSpillere = new ListView<>();
        pane.add(lvSpillere, 1, 1, 1, 1);
        lvSpillere.getItems().addAll(Controller.getSpillere());
        lvSpillere.setPrefHeight(height);
        lvSpillere.setPrefWidth(140);



        // 3rd row

        Label Lblbookinger = new Label("Spillerens bookinger");
        pane.add(Lblbookinger, 2, 0);

        ListView<Booking> lvBookinger = new ListView<>();
        pane.add(lvBookinger, 2, 1, 2, 1);
        lvBookinger.setPrefHeight(height);
        lvBookinger.setPrefWidth(width);



        Label lblopretBooking = new Label("Opret booking:");
        pane.add(lblopretBooking, 2, 2);



        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 3);

        TextField tfDato = new TextField();
        pane.add(tfDato, 3, 3);
        tfDato.setPromptText("dd/M/yyyy");



        Label lblTid = new Label("Tid:");
        pane.add(lblTid, 2, 4);

        TextField tfTid = new TextField();
        pane.add(tfTid, 3, 4);



        CheckBox cbSingle = new CheckBox("single");
        pane.add(cbSingle, 3, 5);



        Button btnBook = new Button("Book bane til spiller");

        pane.add(btnBook, 2, 6);


        // Extra

        lvSpillere.setOnMouseClicked(e -> spillerReselection(lvSpillere, lvBookinger));
        btnBook.setOnAction(e -> LavBooking(lvSpillere, tfDato, tfTid, cbSingle, lvBaner, lvBookinger));
        lvBaner.setOnMouseClicked(e -> antalBookingerPåBane(lvBaner, txaBookingAntal));

    }

    private void antalBookingerPåBane(ListView<Bane> lvBaner, TextArea txaBookingAntal) {

        String bookings = "";

        Bane bane = lvBaner.getSelectionModel().getSelectedItem();

        int[] bookingsAntal = bane.AntalBookningerPrTime();

        for (int i = 0; i < bookingsAntal.length; i++) {
            if (bookingsAntal[i] != 0)
                bookings += "Tid: " + i + "   antal:" + bookingsAntal[i] + "\n";
        }

        txaBookingAntal.setText(bookings);

    }

    private void LavBooking(ListView<Spiller> lvSpillere, TextField tfDato, TextField tfTid, CheckBox cbSingle, ListView<Bane> lvBaner, ListView<Booking> lvBookinger) {

        Spiller spiller = lvSpillere.getSelectionModel().getSelectedItem();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate dato = LocalDate.parse(tfDato.getText(), dateformat);
        LocalTime tid = LocalTime.of(Integer.parseInt(tfTid.getText()), 0, 0);
        boolean erSingle = cbSingle.isSelected();
        Bane banen = lvBaner.getSelectionModel().getSelectedItem();

        Controller.createBooking(spiller, dato, tid, erSingle, banen);

        lvBookinger.getItems().clear();

        lvBookinger.getItems().addAll(spiller.getBookings());


    }

    private void spillerReselection(ListView<Spiller> lvSpillere, ListView<Booking> lvBookinger) {

        Spiller spiller = lvSpillere.getSelectionModel().getSelectedItem();

        lvBookinger.getItems().clear();
        lvBookinger.getItems().addAll(spiller.getBookings());


    }


}
