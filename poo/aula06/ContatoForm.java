import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ContatoForm extends Application { 

    @Override
    public void start(Stage stage) { 
        GridPane grid = new GridPane();
        Scene scn = new Scene(grid, 800, 600);

        Label lblId = new Label("Id: ");
        Label lblNome = new Label("Nome: ");
        Label lblTelefone = new Label("Telefone: ");
        TextField txtId = new TextField();
        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");     
        FlowPane panBotoes = new FlowPane();
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(75);


        grid.getColumnConstraints().addAll(col1, col2);

        grid.add(lblId, 0, 0);
        grid.add(txtId, 1, 0);

        grid.add(lblNome, 0, 1);
        grid.add(txtNome, 1, 1);

        grid.add(lblTelefone, 0, 2);
        grid.add(txtTelefone, 1, 2);

        grid.add(panBotoes, 0, 3);

        stage.setScene(scn);
        stage.show();
    }
    public static void main(String args[]) { 
        Application.launch(ContatoForm.class, args);
    }
}
