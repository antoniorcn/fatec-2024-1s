import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TesteEventos extends Application { 


    class Manipulador implements EventHandler<MouseEvent> { 
        public void handle(MouseEvent evt) { 
            System.out.println("Tipo: " + evt.getEventType() + 
            "   Source: " + evt.getSource().getClass().getName() + 
            "   Target: " + evt.getTarget().getClass().getName() + 
            " X: " + evt.getX() + "  Y: " + evt.getY());
        }
    }


    class ManipuladorTodos implements EventHandler<Event> { 
        public void handle(Event evt) { 
            System.out.println("Tipo: " + evt.getEventType() + 
            "   Source: " + evt.getSource().getClass().getName() + 
            "   Target: " + evt.getTarget().getClass().getName() );
            evt.consume();
        }
    }


    public void start(Stage stage) { 
        FlowPane fp = new FlowPane();

        Scene scn = new Scene (fp, 800, 600);

        ManipuladorTodos man = new ManipuladorTodos();

        Label lblTeste = new Label("Teste de Clique");
        Button btnTeste = new Button("Teste de Botão");
        stage.addEventFilter(Event.ANY, man);

        fp.getChildren().addAll(lblTeste, btnTeste);

        stage.setScene(scn);
        stage.show();
    }

    public static void main(String args[]) { 
        Application.launch(TesteEventos.class, args);
    }
}