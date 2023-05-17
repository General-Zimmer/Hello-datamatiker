package opgaver.opgave2.exercise10_11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {

		for (int i = 25; i <= 25*5; i+= 25) {
			drawCircle(gc, i+25, 100, 40);
		}
	}

	private void drawCircle(GraphicsContext gc, int x, int y, int r)
	{

		gc.strokeOval(x - r, y - r, 2 * r, 2 * r);

		drawCross(gc, x, y);
	}

	public void drawCross(GraphicsContext gc, int x, int y) {

		gc.strokeLine(x, y-5, x, y+5);
		gc.strokeLine(x-5, y, x+5, y);
	}
}
