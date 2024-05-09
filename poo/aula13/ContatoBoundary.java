import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ContatoBoundary extends Application {
    private TextField txtNome = new TextField("");
    private TextField txtTelefone = new TextField("");
    private TextField txtEmail = new TextField("");

    private ContatoControl control = new ContatoControl();

    private TableView<Contato> table = new TableView<>();

    public void generateTable() { 
        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( new PropertyValueFactory<>("nome"));

        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( new PropertyValueFactory<>("telefone"));

        TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory( new PropertyValueFactory<>("email"));

        table.getColumns().addAll(colNome, colTelefone, colEmail);
        table.setItems( control.getLista() );
    }

    public void bind() { 
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
    }

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene( panePrincipal, 500, 300);

        GridPane paneForm = new GridPane();

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");

        paneForm.add(new Label("Nome: "), 0, 0);
        paneForm.add(txtNome, 1, 0);
        paneForm.add(new Label("Telefone: "), 0, 1);
        paneForm.add(txtTelefone, 1, 1);
        paneForm.add(new Label("Email: "), 0, 2);
        paneForm.add(txtEmail, 1, 2);
        paneForm.add(btnGravar, 0,3);
        paneForm.add(btnPesquisar, 1,3);

        bind();
        generateTable();

        btnGravar.setOnAction( e-> control.gravar() );
        btnPesquisar.setOnAction( e-> control.pesquisar() );
        
        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter( table );
        stage.setScene(scn);
        stage.setTitle("Gestão de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
    
}
