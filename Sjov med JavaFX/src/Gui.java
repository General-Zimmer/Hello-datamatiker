import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import scenebuilderting.gui.HelloApplication;

public class Gui extends Application {

    @SuppressWarnings("ConstantConditions")
    @Override
    public void start(Stage stage) {
        stage.setTitle("Konference bookingssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);


        try {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("resources/first.fxml"));
            Scene scene = new Scene(fxmlLoader);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    private void initContent(GridPane pane) {

    }
    public static void main(String[] args) {
        Application.launch(Gui.class);
    }
}
