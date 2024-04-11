import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.beans.binding.Bindings;

public class ContatoBoundary extends Application { 
    private ContatoControl control = new ContatoControl();
    private TableView<Contato> table = new TableView<>();
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();

        Scene scn = new Scene (panPrincipal, 400, 200);
        
        GridPane grid = new GridPane();
        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        Label lblTelefone = new Label("Telefone: ");
        TextField txtTelefone = new TextField();
        Button btnAdicionar = new Button("Adicionar");
        panPrincipal.setTop(grid);
        panPrincipal.setCenter(table);

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( 
            new PropertyValueFactory<Contato, String>("nome"));
        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( 
            new PropertyValueFactory<Contato, String>("tel"));
        table.getColumns().addAll(colNome, colTelefone);
        table.setItems( control.getLista() );

        Bindings.bindBidirectional(control.nome, 
                    txtNome.textProperty());
        Bindings.bindBidirectional(control.telefone, 
                    txtTelefone.textProperty());                    

        btnAdicionar.addEventFilter(ActionEvent.ANY, 
            e -> {
                control.salvar();
        });


        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.addEventFilter(ActionEvent.ANY, 
            e -> { 
                control.pesquisar();
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
        Application.launch(ContatoBoundary.class, args);
    }
}