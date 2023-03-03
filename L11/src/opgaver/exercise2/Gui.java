package opgaver.exercise2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        double startx = 200-(size/2);
        double starty = 200-(size/2);

        Rectangle rect = new Rectangle(startx*0.75, starty, size*2, size);
        rect.setFill(Color.AQUA);
        rect.setStroke(Color.BLACK);
        pane.getChildren().add(rect);


        Text text = new Text(175, 200, "Kristian");
        text.setFill(Color.BLUEVIOLET);
        text.setTextAlignment(TextAlignment.RIGHT);
        pane.getChildren().add(text);


    }
}
