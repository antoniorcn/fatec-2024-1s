import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application {

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        Scene scene = new Scene(panePrincipal, 800, 600);

        MenuBar menu = new MenuBar();

        Menu menuCadastro = new Menu("Cadastro");
        Menu menuAjuda = new Menu("Ajuda");
        menu.getMenus().add(menuCadastro);
        menu.getMenus().add(menuAjuda);

        MenuItem mnuContato = new MenuItem("Contatos");
        MenuItem mnuCreditos = new MenuItem("Creditos");
        menuCadastro.getItems().add(mnuContato);
        menuAjuda.getItems().add(mnuCreditos);
        
        ContatoBoundary contatoBoundary = new ContatoBoundary();
        CreditosBoundary creditosBoundary = new CreditosBoundary();

        panePrincipal.setTop(menu);

        mnuContato.setOnAction( e -> {
            panePrincipal.setCenter(contatoBoundary.render());
        });

        mnuCreditos.setOnAction( e -> { 
            panePrincipal.setCenter(creditosBoundary.render());
        });
        
        stage.setScene(scene);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args);
    }
    
}
