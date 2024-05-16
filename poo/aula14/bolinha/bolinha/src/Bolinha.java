import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Bolinha extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scn = new Scene(pane, 800, 600);

        Canvas canvas = new Canvas(scn.getWidth(), scn.getHeight());
        canvas.widthProperty().bind(
                pane.widthProperty());
        canvas.heightProperty().bind(
                pane.heightProperty());

        pane.getChildren().add(canvas);

        GraphicsContext gc2 = canvas.getGraphicsContext2D();

        AnimationTimer animation = new AnimationTimer() {
            private double px = 50;
            private double py = 50;
            private double velX = 5.0;
            private double velY = 4.0;
            public void handle(long time) {
                // System.out.printf("Width: %5.2f ", scn.getWidth());
                gc2.clearRect(0, 0, scn.getWidth(), scn.getHeight());
                Stop[] stops = new Stop[] {
                        new Stop(0, Color.YELLOW),
                        new Stop(0.4, Color.GREEN),
                        new Stop(0.6, Color.WHITE),
                        new Stop(1, Color.BLUE)
                };
                LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                gc2.setFill(linear);
                // gc2.setFill(Color.color(0, 0, 1, 0.5));
                gc2.fillOval(px, py, 100, 100);
                px = px + velX;
                py = py + velY;
                if (px > (scn.getWidth() - 100)) {
                    velX = -5.0;
                }
                if (py > (scn.getHeight() - 100)) {
                    velY= -4.0;
                }
                if (px < 0) {
                    velX = 5.0;
                }
                if (py < 0) {
                    velY = 4.0;
                }
            }
        };
        animation.start();

        stage.setTitle("Bolinha");
        stage.setScene(scn);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Bolinha.class, args);
    }
}