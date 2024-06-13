package edu.curso;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.converter.NumberStringConverter;
import javafx.util.StringConverter;
import java.time.LocalDate;


public class AlunoBoundary extends Application {
    
    // private StringProperty nome = new SimpleStringProperty("");
    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNome = new TextField();
    private DatePicker txtNascimento = new DatePicker();

    private TableView<Aluno> table = new TableView<>();

    private AlunoControl control = null;

    public void start(Stage stage) { 
        // nome.set("Nome inicial");
        // nome.addListener((obs, antigo, novo) -> {
        //     System.out.println("Nome trocado de :" 
        //     + antigo + " para " + novo);
        // });

        try { 
            control = new AlunoControl();
        } catch (AlunoException e) { 
            alert("Erro ao iniciar o control");
        }

        BorderPane panePrincipal = new BorderPane();
        GridPane grid = new GridPane();

        Scene scn = new Scene (panePrincipal, 400, 200);

        panePrincipal.setTop(grid);
        panePrincipal.setCenter(table);

        grid.add(new Label("Id: "), 0, 0);
        grid.add(txtId, 1, 0);
        grid.add(new Label("Ra: "), 0, 1);
        grid.add(txtRa, 1, 1);
        grid.add(new Label("Nome: "), 0, 2);
        grid.add(txtNome, 1, 2);
        grid.add(new Label("Nascimento: "), 0, 3);
        grid.add(txtNascimento, 1, 3);
        
        // Bindings.bindBidirectional(
        //     txtNome.textProperty(), nome );

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.addEventFilter(ActionEvent.ANY, 
            new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) { 
                    try{ 
                        control.adicionar();
                    } catch(Exception err) { 
                        alert("Erro ao adicionar");
                    }
    
                }
        });

        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.addEventFilter(ActionEvent.ANY, 
        new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
                try{ 
                    control.pesquisarPorNome();
                } catch(Exception err) { 
                    alert("Erro ao pesquisar");
                }
            }
        });
        grid.add(btnAdicionar, 0, 4 );
        grid.add(btnPesquisar, 1, 4 );
        
        createTableView();
        generateBindings();

        stage.setScene(scn);
        stage.show();
    }

    public void generateBindings() { 
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), converter);
        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtNascimento.valueProperty(), control.nascimentoProperty());

    }

    public void alert(String msg) { 
        Alert alert = new Alert(AlertType.INFORMATION, msg, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    public void createTableView() { 
        TableColumn<Aluno, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id"));
        TableColumn<Aluno, String> col2 = new TableColumn<>("Ra");
        col2.setCellValueFactory( new PropertyValueFactory<>("ra"));
        TableColumn<Aluno, String> col3 = new TableColumn<>("Nome");
        col3.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TableColumn<Aluno, LocalDate> col4 = new TableColumn<>("Nascimento");
        col4.setCellValueFactory( new PropertyValueFactory<>("nascimento"));

        TableColumn<Aluno, Void> colAcoes = new 
		TableColumn<>("Ações");
        Callback<TableColumn<Aluno, Void>, TableCell<Aluno, Void>>
        callback = new Callback<>() { 
            public TableCell<Aluno, Void> call(TableColumn<Aluno, Void> coluna) {
                TableCell<Aluno, Void> tc = new TableCell<>() {
                    final Button btnExcluir = new Button("Excluir");
                    {
                        btnExcluir.setOnAction(event -> { 
                            Aluno a1 = table.getItems().get(getIndex());
                            try { 
                                control.excluir(a1.getId());
                            } catch(Exception err) { 
                                alert("Erro ao excluir o usuario");
                            }
                        });
                    }
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnExcluir);
                        }
                    }
                };
                return tc;
            }
        };
        table.setItems( control.getLista() );
        colAcoes.setCellFactory( callback );

        table.getColumns().addAll(col1, col2, col3, col4, colAcoes);



    }

    public static void main(String args[]) { 
        Application.launch(AlunoBoundary.class, args);
    }
}