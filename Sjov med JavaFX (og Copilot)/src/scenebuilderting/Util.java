package scenebuilderting;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

public class Util {
    /**
     * Moves a node to a random location on the pane, but not too close to the reference node
     * @param pane The pane to move the node on
     * @param moved The node to move
     * @param reference The node to not move the node too close to
     */
    public static void moveNode(Pane pane, Control moved, Control reference) {
        double x;
        double y;
        double layoutX = reference.getLayoutX();
        double layoutY = reference.getLayoutY();
        double width = reference.widthProperty().get();
        double height = reference.heightProperty().get();
        int tries = 0;
        do {
            x = pane.getWidth() * Math.random();
            y = pane.getHeight() * Math.random();
            tries++;

        } while ((x > layoutX - width &&
                x < layoutX + width &&
                y > layoutY - height &&
                y < layoutY + height)
                || x < 0 || y < 0 || x > pane.getWidth()+width || y > pane.getHeight()+height ||
                x > pane.getWidth()-width || y > pane.getHeight()-height);
        moved.setLayoutX(x);
        moved.setLayoutY(y);
        System.out.println("tries " + tries);
        System.out.println(width + " " + height);
        System.out.println(moved.styleProperty());
    }
}
