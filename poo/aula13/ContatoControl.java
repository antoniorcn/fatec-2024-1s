import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
    private ObservableList<Contato> lista = 
        FXCollections.observableArrayList();

    private ContatoDAO dao = new ContatoDAOImpl();

    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");

    public void limparCampos() { 
        nome.set("");
        telefone.set("");
        email.set("");
    }

    public Contato toEntity() { 
        Contato a = new Contato();
        a.setNome( nome.get() );
        a.setTelefone( telefone.get() );
        a.setEmail( email.get() );
        return a;
    }

    public void fromEntity(Contato a) { 
        telefone.set(a.getTelefone());
        nome.set(a.getNome());
        email.set(a.getEmail());
    }

    public void gravar() { 
        Contato c = toEntity();
        dao.adicionar(c);
        pesquisarTodos();
        limparCampos();
    }

    public void pesquisar() { 
        for (Contato c : lista) { 
            if (c.getNome().contains( nome.get() )) { 
                fromEntity(c);
            }
        }
    }

    public void excluir( Contato c ) { 
        // TODO: Excluir contato
    }

    public void pesquisarTodos() { 
        List<Contato> tempLista = dao.pesquisarTodos();
        lista.clear();
        lista.addAll( tempLista );
    }

    public ObservableList<Contato> getLista() {
        return this.lista;
    }

    public StringProperty telefoneProperty() { 
        return this.telefone;
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public StringProperty emailProperty() { 
        return this.email;
    }
    
}
