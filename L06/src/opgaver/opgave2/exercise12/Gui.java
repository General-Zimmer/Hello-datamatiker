package opgaver.opgave2.exercise12;

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


		drawTriangleWithInnerWithInner(gc, 20, 150, 80);

	}

	public void drawTriangle(GraphicsContext gc, double x, double y, double h) {

		// Buttom line
		gc.strokeLine(x, y, x+(h*2), y);
		// First top line
		gc.strokeLine(x, y, x+h, y-h);
		// Second top line
		gc.strokeLine(x+(h*2), y, x+h, y-h);

	}

	public void drawTriangleWithInner(GraphicsContext gc, double x, double y, double h) {
		//Big one
		drawTriangle(gc, x, y, h);

		// Small ones
		drawTriangle(gc, x, y, h/3); // First triangle
		drawTriangle(gc, x+(h*2-(h/3*2)), y, h/3); // Far right triangle
		drawTriangle(gc, x+h-(h/3), y-h+(h/3), h/3); // Top triangle

	}

	public void drawTriangleWithInnerWithInner(GraphicsContext gc, double x, double y, double h) {
		//Big one
		drawTriangle(gc, x, y, h);

		//Small ones
		drawTriangleWithInner(gc, x, y, h/3); // First triangle
		drawTriangleWithInner(gc, x+(h*2-(h/3*2)), y, h/3); // Far right triangle
		drawTriangleWithInner(gc, x+h-(h/3), y-h+(h/3), h/3); // Top triangle
	}

}
