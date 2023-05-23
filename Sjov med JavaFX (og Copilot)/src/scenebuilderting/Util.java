package scenebuilderting;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

public class Util {
    public static void moveNode(Pane pane, Control moved, Control reference) {
        double x;
        double y;
        do {
            x = pane.getWidth() * Math.random()*0.75;
            y = pane.getHeight() * Math.random()*0.9;
        } while (reference.getLayoutX()*0.85 > x && reference.getLayoutX()*1.15 < x &&
                reference.getLayoutY()*0.90 > y && reference.getLayoutY()*1.1 < y);
        moved.setLayoutX(x);
        moved.setLayoutY(y);
    }
}
