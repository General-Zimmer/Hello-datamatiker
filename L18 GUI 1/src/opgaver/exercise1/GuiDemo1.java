package opgaver.exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo1 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblNameFirst = new Label("First name");
        pane.add(lblNameFirst, 0, 0);


        Label lblNameLast = new Label("Last name");
        pane.add(lblNameLast, 3, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        TextField txfNameFirst = new TextField();
        pane.add(txfNameFirst, 0, 1, 2, 1);

        TextField txfNameLast = new TextField();
        pane.add(txfNameLast, 3, 1, 2, 1);


        Label lblFullName = new Label("Full name");
        pane.add(lblFullName, 0, 2);

        TextField txfFullName = new TextField();
        pane.add(txfFullName, 0, 4, 4, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnCombine = new Button("combine");
        btnCombine.setOnAction(e -> CombineName(txfNameFirst, txfNameLast, txfFullName));
        pane.add(btnCombine, 3, 5);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

    }

    public void CombineName(TextField first, TextField last, TextField combined) {
        combined.textProperty().set(first.getText().trim() + " " + last.getText().trim());
    }

}
