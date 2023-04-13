package opgaver.opgave2;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class util {
    public static void specialWidgets(GridPane scorePane, int width,  TextField txfSumSame, TextField txfBonus, TextField txfSumOther, TextField txfTotal) {
        txfSumSame.setPrefWidth(width);
        txfBonus.setPrefWidth(width);
        txfSumOther.setPrefWidth(width);
        txfTotal.setPrefWidth(width);


        scorePane.add(txfSumSame, 3, 5);
        Label lbSumSame = new Label("Sum");
        scorePane.add(lbSumSame, 2, 5);

        scorePane.add(txfBonus, 3, 6);
        Label lbBonus = new Label("Bonus");
        scorePane.add(lbBonus, 2, 6);


        scorePane.add(txfSumOther, 3, 16);
        Label lbSumOther = new Label("Sum");
        scorePane.add(lbSumOther, 2, 16);

        scorePane.add(txfTotal, 3, 17);
        Label lbTotal = new Label("Total");
        scorePane.add(lbTotal, 2, 17);
    }
}
