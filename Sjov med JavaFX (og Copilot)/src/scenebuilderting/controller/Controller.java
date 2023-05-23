package scenebuilderting.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import scenebuilderting.Util;

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

    @FXML
    public void onYeetPress() {
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
    public void onMouseOver() {

        if (movedCount > 19) {
            random_button.setVisible(false);
            return;
        }
        Util.moveNode(funPane, random_button, random_button);

        switch (movedCount) {
            case 0 -> random_button.setText("Aye!");
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
            case 14 -> random_button.setText("Just leave me aloooone!");
            case 15 -> random_button.setText("stop meanie!");
            case 16 -> random_button.setText("Get a life");
            case 17 -> random_button.setText("And touch grass");
            case 18 -> random_button.setText("You filthy animal!");
            case 19 -> random_button.setText("fuck you, I'm gonna go play Minecraft");
        }
        movedCount++;
    }

    @FXML
    public void onColorPicked() {
        yeetButt.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        random_button.setStyle("-fx-background-color: #" + color.getValue().toString().substring(2));
        
    }
}
