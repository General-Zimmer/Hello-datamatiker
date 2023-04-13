package opgaver.opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import opgaver.opgave1.YatzyDice;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        double widgetSize = 80;
        for (int i = 0; i < txfValues.length; i++) {
            // TextFields
            txfValues[i] = new TextField();
            TextField txfRef = txfValues[i];
            txfRef.setPrefSize(widgetSize, widgetSize);

            // Hold buttons
            cbxHolds[i] = new CheckBox();
            CheckBox cbRef = cbxHolds[i];
            cbRef.setPadding(new Insets(0, 0, 0, widgetSize/5));
            cbRef.setText("hold");

            // Placing widgets
            dicePane.add(cbRef, i, 1);
            dicePane.add(txfRef, i, 0);
        }
        // lblThrowCount
        dicePane.add(lblThrowCount, 2, 2);
        lblThrowCount.setText("thrown " + dice.getThrowCount());

        // and btnThrow
        dicePane.add(btnThrow, 3, 2);
        btnThrow.setOnAction(actionEvent -> actionThrow());


        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults,
        for (int i = 0, j = 0; i < 15; i++, j++) {




            txfResults.add(i, new TextField());
            TextField txRef = txfResults.get(i);
            txRef.setPrefWidth(width);

            //todo Add sum, bonus, and total thingies in this
            if (i == 6)
                j++;

            scorePane.add(txRef, 0, j);
        }

        // labels and text fields for sums, bonus and total.
        util.specialWidgets(scorePane, width, txfSumSame, txfBonus, txfSumOther, txfTotal);

    }

    // -------------------------------------------------------------------------

    public void actionThrow() {
        boolean[] holdStatus = new boolean[cbxHolds.length];
        for (int i = 0; i < holdStatus.length; i++) {
            CheckBox box = cbxHolds[i];

            if (box.isSelected()) {
                holdStatus[i] = true;
                box.setDisable(true);
            }
            else
                holdStatus[i] = false;
        }

        dice.throwDice(holdStatus);

        int[] values = dice.getValues();
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(values[i]));
        }
    }

    // -------------------------------------------------------------------------

    public void actionResultFields() {

    }

}
