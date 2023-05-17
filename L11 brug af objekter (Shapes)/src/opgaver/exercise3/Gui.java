package opgaver.exercise3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        double size = 75;
        double startx = 200;
        double starty = 200;

        Circle cir = new Circle(startx, starty, size);
        cir.setFill(Color.AQUA);
        cir.setStroke(Color.BLACK);
        pane.getChildren().add(cir);

        Circle smol1 = new Circle(startx-20, starty-10, 10);
        smol1.setFill(Color.AQUA);
        smol1.setStroke(Color.BLACK);
        pane.getChildren().add(smol1);

        Circle smol2 = new Circle(startx+20, starty-10, 10);
        smol2.setFill(Color.AQUA);
        smol2.setStroke(Color.BLACK);
        pane.getChildren().add(smol2);



    }
}
