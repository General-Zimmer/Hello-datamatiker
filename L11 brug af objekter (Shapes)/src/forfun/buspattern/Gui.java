package forfun.buspattern;

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
        Scene scene = new Scene(pane, 800, 650);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        double size = 30;
        double startx = -200;
        double starty = 635;
        double offset = 1.5;
        double circleReduction = 3;

        for (int i = 0; i < 17; i++) {
            double tempX = startx+(size*2+offset)*i;

            for (int j = 0; j < 10; j++) {
                Circle cir = new Circle(tempX + (size * j), starty - ((size+offset)*1.75) * j, size - (circleReduction * j));
                cir.setFill(Color.BLACK);
                pane.getChildren().add(cir);

            }
        }




    }
}
