package opgaver.exercise6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    private Student student;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);



        Label lblStudentInfo = new Label("Student Info:");
        pane.add(lblStudentInfo, 0, 0);

        TextArea TAStudentInfo = new TextArea();
        TAStudentInfo.prefHeight(150);
        TAStudentInfo.maxWidth(50);
        pane.add(TAStudentInfo, 0, 1, 3, 1);



        Label lblName = new Label("Full name:");
        pane.add(lblName, 0, 3);

        TextField txfName = new TextField();
        pane.add(txfName, 1, 3);





        Label lbnAge = new Label("Age:");
        pane.add(lbnAge, 0, 4);

        TextField txfAge = new TextField();
        pane.add(txfAge, 1, 4);




        Label lbnActive = new Label("Active:");
        pane.add(lbnActive, 0, 5);

        CheckBox cbActive = new CheckBox();
        pane.add(cbActive, 1, 5);



        // Horizontel box for the 3 buttons
        HBox hbButtons = new HBox();
        hbButtons.setSpacing(25);


        Button btnCreate = new Button("Create");
        btnCreate.setOnAction(e -> createStudent(TAStudentInfo, txfName, txfAge, cbActive));
        hbButtons.getChildren().add(btnCreate);



        Button btnUpdate = new Button("Update");
        btnUpdate.setOnAction(e -> updateStudent(TAStudentInfo, txfName, txfAge, cbActive));
        hbButtons.getChildren().add(btnUpdate);


        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e -> deleteStudent(TAStudentInfo));
        hbButtons.getChildren().add(btnDelete);

        pane.add(hbButtons, 0, 6, 3, 1);
    }

    private void createStudent(TextArea studentInfo, TextField TFname, TextField TFage, CheckBox CBactive) {
        String name = TFname.getText();
        String age = TFage.getText();
        boolean isActive = CBactive.isSelected();

        student = new Student(name, isActive, Integer.parseInt(age));
        updateStudent(studentInfo, TFname, TFage, CBactive);

    }

    private void updateStudent(TextArea studentInfo, TextField TFname, TextField TFage, CheckBox CBactive) {
        studentInfo.clear();
        studentInfo.insertText(0,
                "Name: " + TFname.getText() + "\n"
                + "Age: " + TFage.getText() + "\n" +
                "Active: " + CBactive.isSelected());

    }

    private void deleteStudent(TextArea studentInfo) {
        studentInfo.clear();
        student = null;
    }

}
