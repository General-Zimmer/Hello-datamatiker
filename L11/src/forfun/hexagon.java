package forfun;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class hexagon extends Application {

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
        double size = 150;
        double startx = 200;
        double starty = 400;
        double offset = 2;
        double circleReduction = 3;


        pane.getChildren().add(myPolygon(startx, starty, size));





    }

    private Polygon myPolygon(double startx, double starty, double radius) {

        double degree = Math.PI / 180 * 30;
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

