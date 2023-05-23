package scenebuilderting;

import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Util {
    /**
     * Moves a node to a random location on the pane, but not inside the reference node or outside the pane
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
            if (tries > 1000) {
                pane.setLayoutX(width+30);
                pane.setLayoutY(height+30);
            }

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
        System.out.println("width: " + width + " Height: " + height);
        System.out.println(moved.styleProperty());
    }

    /**
     * Gets a MediaPlayer from a file
     * Note: The file must be in the resource folder otherwise the audio file will never be found.
     * @param fileName The name of the file to get the MediaPlayer from
     * @return The MediaPlayer from the file
     */
    public static MediaPlayer getMediaPlayerFromFile(String fileName) {
        File file = new File(fileName);
        String filePath = file.toURI().toString().substring(0, file.toURI().toString().length() - fileName.length()) + "/Sjov%20med%20JavaFX%20(og%20Copilot)/resources/"+fileName;
        Media media = new Media(filePath);
        return new MediaPlayer(media);
    }
}
