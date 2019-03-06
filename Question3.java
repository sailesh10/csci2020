import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Question3 extends Application {
    private double radius = 10;
    private Circle[] circle = {new Circle(40, 40, 20), new Circle(140, 40, 20),
        new Circle(60, 140, 20)};
    private Text[] text = {new Text(), new Text(), new Text()};
    private Line[] line = {new Line(), new Line(), new Line()};
    private double paneWidth = 300;
    private double paneHeight = 250;
    double bigCircleRadius = Math.min(paneWidth, paneHeight) * 0.4;
    Circle bigCircle = new Circle(
            paneWidth / 2, paneHeight / 2, bigCircleRadius);

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        setLines();
        bigCircle.setFill(Color.WHITE);
        bigCircle.setStroke(Color.BLACK);

        circle[0].setFill(Color.RED);
        circle[1].setFill(Color.RED);
        circle[2].setFill(Color.RED);

        pane.getChildren().addAll(bigCircle,
                text[0], text[1], text[2], circle[0], circle[1], circle[2],
                line[0], line[1], line[2]);

        // Creates a scene in stage
        Scene scene = new Scene(pane, paneWidth, paneHeight);
        primaryStage.setTitle("Question3"); // Set stage title
        primaryStage.setScene(scene); // Placeing scene in the stage
        primaryStage.show(); // Displaying the stage

        circle[0].setOnMouseDragged(e -> {
            if (circle[0].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                circle[0].setCenterX(e.getX());
                circle[0].setCenterY(e.getY());
                setLines();
            }
        });

        circle[1].setOnMouseDragged(e -> {
            if (circle[1].contains(e.getX(), e.getY())) {
                circle[1].setCenterX(e.getX());
                circle[1].setCenterY(e.getY());
                setLines();
            }
        });

        circle[2].setOnMouseDragged(e -> {
            if (circle[2].contains(e.getX(), e.getY())) {
                circle[2].setCenterX(e.getX());
                circle[2].setCenterY(e.getY());
                setLines();
            }
        });
    }

    private void setLines() {
        line[0].setStartX(circle[0].getCenterX());
        line[0].setStartY(circle[0].getCenterY());
        line[0].setEndX(circle[1].getCenterX());
        line[0].setEndY(circle[1].getCenterY());
        line[1].setStartX(circle[0].getCenterX());
        line[1].setStartY(circle[0].getCenterY());
        line[1].setEndX(circle[2].getCenterX());
        line[1].setEndY(circle[2].getCenterY());
        line[2].setStartX(circle[1].getCenterX());
        line[2].setStartY(circle[1].getCenterY());
        line[2].setEndX(circle[2].getCenterX());
        line[2].setEndY(circle[2].getCenterY());

        // Computing the angles
        double a = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[1].getCenterX(), circle[1].getCenterY());
        double b = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double c = new Point2D(circle[1].getCenterX(), circle[1].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double[] angle = new double[3];
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        for (int i = 0; i < 3; i++) {
            text[i].setX(circle[i].getCenterX());
            text[i].setY(circle[i].getCenterY() - radius - 15);
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
  }
