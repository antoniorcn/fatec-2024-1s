import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Camera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;

public class SistemaSolar extends Application {

    public Image carregarImagem(String path) {
        InputStream isTemp = getClass().getResourceAsStream(path);
        if (isTemp != null) {
            return new Image(isTemp);
        }
        System.out.printf("Image  %s não localizado%n", path);
        return null;
    }

    public Point2D calculaPonto(double centroX, double centroY, double raio, double angulo) {
        double anguloRadianos = angulo / 180.0 * Math.PI;
        double catetoOposto = raio * Math.sin( anguloRadianos );
        double catetoAdjacente = raio * Math.cos( anguloRadianos ) * 3.2;
        double x = centroX + catetoAdjacente;
        double y = centroY + catetoOposto;
        return new Point2D(x, y);
    }

    public Point2D calcularCentroImagem( Image imagem, double x, double y) {
        double nX = x - (imagem.getWidth()/2);
        double nY = y - (imagem.getHeight()/2);
        return new Point2D(nX, nY);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scn = new Scene(pane, 800, 600);
        Canvas canvas = new Canvas(scn.getWidth(), scn.getHeight());
        canvas.widthProperty().bind( scn.widthProperty() );
        canvas.heightProperty().bind( scn.heightProperty() );

        pane.getChildren().add(canvas);

        GraphicsContext gc2 = canvas.getGraphicsContext2D();
        gc2.setFill(Color.BLACK);
        gc2.fillRect(0, 0, scn.getWidth(), scn.getHeight());


        Image imgSpace = carregarImagem("/images/space.png");
        Image imgSun = carregarImagem("/images/sun.png");
        Image imgEarth = carregarImagem("/images/earth.png");
        Image imgMars = carregarImagem("/images/mars.png");

        new AnimationTimer() {
            private double velTerra = 1.0;
            private double anguloTerra = 0.0;
            private double velMarte = 1.4;
            private double anguloMarte = 90.0;
            public void handle(long time) {
                anguloTerra += velTerra;
                anguloTerra %= 360;

                anguloMarte += velMarte;
                anguloMarte %= 360;

                /* if (anguloTerra > 360) {
                    anguloTerra = 0;
                } */

                double centroX =  scn.getWidth() / 2;
                double centroY =  scn.getHeight() / 2;

                Point2D pTerra = calculaPonto(centroX, centroY, 200.0, anguloTerra);
                Point2D pMarte = calculaPonto(centroX, centroY, 350.0, anguloMarte);

                Point2D pSol = calcularCentroImagem(imgSun, centroX, centroY);
                pTerra = calcularCentroImagem(imgEarth, pTerra.getX(), pTerra.getY());
                pMarte = calcularCentroImagem(imgMars, pMarte.getX(), pMarte.getY());

                gc2.drawImage(imgSpace, 0, 0, scn.getWidth(), scn.getHeight());
                gc2.drawImage(imgSun, pSol.getX(), pSol.getY());
                gc2.drawImage(imgEarth, pTerra.getX(), pTerra.getY());
                gc2.drawImage(imgMars, pMarte.getX(), pMarte.getY());

            }

        }.start();


        stage.setScene(scn);
        stage.setTitle("Sistema Solar");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(SistemaSolar.class, args);
    }
}
