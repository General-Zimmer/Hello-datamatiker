package scenebuilderting.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import scenebuilderting.Util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {

    @FXML
    private Button yeetButt;
    @FXML
    private Button random_button;
    @FXML
    private ColorPicker color;
    @FXML
    private Label theYeet;
    @FXML
    private AnchorPane funPane;
    private int movedCount = 0;

    MediaPlayer mediaPlayer;

    public Controller() {
        File file = new File("screw_u.mp3");
        String filePath = file.toURI().toString().substring(0, file.toURI().toString().length() - 11) + "/Sjov%20med%20JavaFX%20(og%20Copilot)/resources/screw_u.mp3";
        final Media hit = new Media(filePath);
        mediaPlayer = new MediaPlayer(hit);
    }

    @FXML
    public void onYeetPress() {
        // Switch between YEET and UnYEET
        if (theYeet.getText().equals("")) {
            // Move theYeet to another location
            Util.moveNode(funPane, theYeet, yeetButt);
            theYeet.setText("YEET");
            yeetButt.setText("UnYEET");
        } else {
            yeetButt.setText("the YEET");
            theYeet.setText("");
        }
    }

    @FXML
    public void onMouseOver() throws URISyntaxException, IOException {
        // Hide random_button after 20 moves
        if (movedCount > 19) {
            random_button.setVisible(false);
            return;
        }


        // Change text
        switch (movedCount) {
            case 0 -> random_button.setText("Aye! I'm just a button!");
            case 1 -> random_button.setText("You almost touched me");
            case 2 -> random_button.setText("Stop it!");
            case 3 -> random_button.setText("I'm warning you!");
            case 4 -> random_button.setText("I'm gonna disappear if you keep going!");
            case 5 -> random_button.setText("Whyyy");
            case 6 -> random_button.setText("Go away!");
            case 7 -> random_button.setText("AHHHH STTOOOOPPP");
            case 8 -> random_button.setText("AHHH");
            case 9 -> random_button.setText("AHHHHHHHH!");
            case 12 -> random_button.setText("AHHHHHHHH, fuck yoooou");
            case 13 -> random_button.setText("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEeeeeeeEEEEEEEEEEEEeeEEEEEEEEEEE");
            case 14 -> random_button.setText("Just leave me aloooone!");
            case 15 -> random_button.setText("stop meanie!");
            case 16 -> random_button.setText("Get a life");
            case 17 -> random_button.setText("And touch grass (Not me)");
            case 18 -> random_button.setText("You filthy animal!");
            case 19 -> random_button.setText("screw you, I am gonna go play Mine-craft!");
        }
        movedCount++;


        // Update pane so the button size is up to date before move is calculated.
        funPane.snapshot(null, null);

        // play media when
        if (movedCount == 19+1)
            mediaPlayer.play();


        // Move random_button to another location
        Util.moveNode(funPane, random_button, random_button);





    }

    @FXML
    public void onColorPicked() {
        yeetButt.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        random_button.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        
    }
}
