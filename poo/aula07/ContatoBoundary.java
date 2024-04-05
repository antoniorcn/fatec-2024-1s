import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.List;
import java.util.ArrayList;

public class TesteEventos extends Application { 
    private List<Contato> lista = new ArrayList<>();

    public void start(Stage stage) { 
        GridPane grid = new GridPane();

        Scene scn = new Scene (grid, 400, 200);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        Label lblTelefone = new Label("Telefone: ");
        TextField txtTelefone = new TextField();
        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.addEventFilter(ActionEvent.ANY, 
            new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) { 
                    Contato c = new Contato();
                    c.setNome( txtNome.getText() );
                    c.setTel( txtTelefone.getText() );
                    lista.add(c);
                    txtNome.setText("");
                    txtTelefone.setText("");
                }
        });


        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.addEventFilter(ActionEvent.ANY, 
        new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
                for( Contato c : lista) { 
                    if (c.getNome().contains(txtNome.getText())) { 
                        txtNome.setText(c.getNome());
                        txtTelefone.setText(c.getTel());
                    }
                }
            }
        });
        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblTelefone, 0, 1);
        grid.add(txtTelefone, 1, 1);
        grid.add(btnAdicionar, 0,2 );
        grid.add(btnPesquisar, 1,2 );
        
        stage.setScene(scn);
        stage.show();
    }

    public static void main(String args[]) { 
        Application.launch(TesteEventos.class, args);
    }
}