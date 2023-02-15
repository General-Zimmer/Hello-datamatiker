package opgaver.exercise1;

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
		int hori = 30;
		int verti = 20;

		int arrow1_1 = 100;
		int arrow1_2 = 75;
		gc.strokeLine(arrow1_1,arrow1_2, arrow1_1-hori, arrow1_2-verti);
		gc.strokeLine(arrow1_1,arrow1_2, arrow1_1-hori, arrow1_2+verti);

		int arrow2_1 = 100;
		int arrow2_2 = 125;
		gc.strokeLine(arrow2_1,arrow2_2, arrow2_1-hori, arrow2_2-verti);
		gc.strokeLine(arrow2_1,arrow2_2, arrow2_1-hori, arrow2_2+verti);

		int arrow3_1 = 20;
		int arrow3_2 = 50;
		gc.strokeLine(arrow3_1,arrow3_2, arrow3_1+hori, arrow3_2+verti);
		gc.strokeLine(arrow3_1,arrow3_2, arrow3_1+hori, arrow3_2-verti);

		//D I've used variables to easily change the arrows' properties

	}
}
