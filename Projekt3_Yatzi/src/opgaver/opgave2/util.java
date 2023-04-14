package opgaver.opgave2;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import opgaver.opgave1.YatzyDice;

import java.util.ArrayList;

public class util {
    public static void addSpecialWidgets(GridPane scorePane, int width, TextField txfSumSame, TextField txfBonus, TextField txfSumOther, TextField txfTotal) {
        txfSumSame.setPrefWidth(width);
        txfBonus.setPrefWidth(width);
        txfSumOther.setPrefWidth(width);
        txfTotal.setPrefWidth(width);

        txfSumSame.setEditable(false);
        txfBonus.setEditable(false);
        txfSumOther.setEditable(false);
        txfTotal.setEditable(false);


        scorePane.add(txfSumSame, 3, 5);
        Label lbSumSame = new Label("Sum");
        scorePane.add(lbSumSame, 2, 5);

        scorePane.add(txfBonus, 3, 6);
        Label lbBonus = new Label("Bonus");
        scorePane.add(lbBonus, 2, 6);


        scorePane.add(txfSumOther, 3, 15);
        Label lbSumOther = new Label("Sum");
        scorePane.add(lbSumOther, 2, 15);

        scorePane.add(txfTotal, 3, 16);
        Label lbTotal = new Label("Total");
        scorePane.add(lbTotal, 2, 16);
    }

    public static void addThrowContent(TextField[] txfValues, CheckBox[] cbxHolds, GridPane dicePane, double widgetSize) {
        for (int i = 0; i < txfValues.length; i++) {
            // TextFields
            txfValues[i] = new TextField();
            TextField txfRef = txfValues[i];
            txfRef.setPrefSize(widgetSize, widgetSize);
            txfRef.setEditable(false);
            txfRef.setFocusTraversable(false);

            // Hold buttons
            cbxHolds[i] = new CheckBox();
            CheckBox box = cbxHolds[i];
            box.setPadding(new Insets(0, 0, 0, widgetSize/5));
            box.setText("hold");

            // Placing widgets
            dicePane.add(box, i, 1);
            dicePane.add(txfRef, i, 0);
        }
    }

    public static void scoreLabels(GridPane scorePane, ArrayList<String> namesOfResults, double width) {
        for (int i = 1; i <= 6; i++) {
            Label lbl = new Label();
            lbl.setText(i + "-s");
            scorePane.add(lbl, 0, (i-1));
        }
        for (int i = 7; i < 16; i++){
            Label lbl = new Label(namesOfResults.get(i - 1));
            scorePane.add(lbl, 0, i, 1, 1);
            TextField txf = new TextField();
            txf.setPrefWidth(width);
            txf.setEditable(false);
        }
    }

    public static void setThrowText(YatzyDice dice, Label lab, String throwText) {
        lab.setText(throwText + dice.getThrowCount());
    }

}
