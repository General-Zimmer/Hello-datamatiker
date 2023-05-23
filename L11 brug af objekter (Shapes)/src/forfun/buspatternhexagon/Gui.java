package forfun.buspatternhexagon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        double x = 1200;
        double y = 1000;

        Pane pane = new Pane();
        this.initContent(pane, x, y);
        Scene scene = new Scene(pane, x, y);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane, double x, double y) {

        // polygon things
        double size = 60;
        double offset = -size*0.12;
        double circleReduction = size*0.1;
        double minsize = 5;
        double amount = 0;

        // Start
        double startx = -x-200;
        @SuppressWarnings("UnnecessaryLocalVariable")
        double starty = y;

        // Make sure a minimum size is reached
        do amount++;
        while (size-circleReduction*amount >= minsize);



        for (int i = 0; i < 100; i++) {
            double tempX = startx+(size*2+offset)*i;

            for (int j = 0; j < amount; j++)

                pane.getChildren().add(hexagon(
                        tempX + (size+offset/2) * j,
                        starty - (size+offset)*1.75 * j,
                        size - circleReduction * j));
        }
    }

    private Polygon hexagon(double startx, double starty, double radius) {

        double degree = Math.PI / 180.0 * 30.0;
        double sin = Math.sin(degree) * radius;
        double cos = Math.cos(degree) * radius;

        Polygon poly = new Polygon(
                startx - sin, starty + cos, //bottom left
                startx + sin, starty + cos,  //bottom right
                startx + radius, starty, //right
                startx + sin, starty - cos, //top right
                startx - sin, starty - cos, //top left
                startx - radius, starty //left
        );
        poly.rotateProperty().set(30);


        return poly;
    }

}

