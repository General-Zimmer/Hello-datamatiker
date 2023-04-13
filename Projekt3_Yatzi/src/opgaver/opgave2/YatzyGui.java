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
    private final YatzyDice dice = new YatzyDice();

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
        double widgetSize = 80;


        // txfValues, chbHolds
        util.addThrowContent(txfValues, cbxHolds, dicePane, widgetSize);

        // lblThrowCount
        dicePane.add(lblThrowCount, 2, 2);
        util.setThrowText(dice, lblThrowCount);

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
            txRef.setOnAction(actionEvent -> actionResultFields());

            if (i == 6)
                j++;

            scorePane.add(txRef, 0, j);
        }

        // labels and text fields for sums, bonus and total.
        util.addSpecialWidgets(scorePane, width, txfSumSame, txfBonus, txfSumOther, txfTotal);

    }

    // -------------------------------------------------------------------------

    public void actionThrow() {

        // keep track of throws
        dice.increaseThrowCount();
        util.setThrowText(dice, lblThrowCount);

        // Generate Hold status
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

        // Generate throw
        int[] values = dice.getValues();
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(values[i]));
        }

        // Calculate scores
        int[] results = dice.getResults();
        for (int i = 0; i < results.length; i++) {
            txfResults.get(i).setText(String.valueOf(results[i]));
        }
    }

    // -------------------------------------------------------------------------

    public void actionResultFields() {


    }

}
