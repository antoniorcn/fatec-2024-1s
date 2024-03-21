import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
public class Teste extends Application { 
    @Override
    public void start(Stage stage) { 
        Pane panePrincipal = new Pane();
        Scene scn = new Scene(panePrincipal, 800, 600);
        stage.setScene(scn);
        stage.show();
    }
    public static void main(String args[]) { 
        Application.launch(Teste.class, args);
    }
}