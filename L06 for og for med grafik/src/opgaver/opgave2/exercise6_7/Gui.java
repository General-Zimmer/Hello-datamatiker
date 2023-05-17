package opgaver.opgave2.exercise6_7;

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
		// Replace the statement here with your code.
		int y1 = 170; // start point: (x,y1)
		int y2 = 160; // end point: (x,y2)

		// Long line and arrowhead
		gc.strokeLine(10, y2+5, 180, y2+5);
		gc.strokeLine(180, y2+5, 175, y2-5);
		gc.strokeLine(180, y2+5, 175, y2+12);

		//
		for (int i = 0; i <= 20; i++) {
			int x = 10 + i * 8;
			if (i % 5 == 0) {
				gc.strokeLine(x, y1 + 5, x, y2 - 5);
				gc.fillText(Integer.toString(i), x-5, y1+15);
			}
			else
				gc.strokeLine(x, y1, x, y2);

		}
	}
}
