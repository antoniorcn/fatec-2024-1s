import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreditosBoundary implements Boundary {

    public Pane render() { 
        VBox box = new VBox();
        box.getChildren().add( new Label("Fatec Zona Leste"));
        box.getChildren().add( new Label("Curso de Analise e Desenvolvimento de Sistemas"));
        box.getChildren().add( new Label("Programação Orientada a Objetos"));
        box.getChildren().add( new Label("prof. Antonio Carvalho"));
        box.getChildren().add( new Label("feito por João e Maria"));
        return box;
    }
    
}
