package model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class DotTriangle {

    public static void createTriangle(Pane pane, double startx, double starty) {
        // polygon things
        double size = 60;
        double placementLength = -size*0.12+size;
        double amount = 8;

        double changingAmount = 0;

        for (int i = 0; i < amount; i++) {
            changingAmount++;
            for (int j = 0; j < changingAmount; j++) {
                Circle cir = new Circle();
                cir.setFill(Color.BLACK);
                pane.getChildren().add(cir);
            }
        }
        

    }
}
