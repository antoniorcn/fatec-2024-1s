import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary extends Application {
    private TextField txtRa = new TextField("");
    private TextField txtNome = new TextField("");
    private DatePicker dtaNascimento = new DatePicker(LocalDate.now());
    private TextField txtMedia = new TextField("0.0");

    private AlunoControl control = new AlunoControl();

    public void bind() { 
        StringConverter<Number> numberConverter = new NumberStringConverter();
        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(dtaNascimento.valueProperty(), control.nascimentoProperty());
        Bindings.bindBidirectional(txtMedia.textProperty(), control.mediaProperty(), 
                        (StringConverter<Number>)numberConverter);
    }

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene( panePrincipal, 500, 300);

        GridPane paneForm = new GridPane();

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");

        paneForm.add(new Label("RA: "), 0, 0);
        paneForm.add(txtRa, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Nascimento: "), 0, 2);
        paneForm.add(dtaNascimento, 1, 2);
        paneForm.add(new Label("Media: "), 0, 3);
        paneForm.add(txtMedia, 1, 3);
        paneForm.add(btnGravar, 0,4);
        paneForm.add(btnPesquisar, 1,4);

        bind();

        btnGravar.setOnAction( e-> control.gravar() );
        btnPesquisar.setOnAction( e-> control.pesquisar() );
        
        panePrincipal.setTop( paneForm );
        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }
    
}
