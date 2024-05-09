import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
    private ObservableList<Contato> lista = 
        FXCollections.observableArrayList();

    private ContatoDAO dao = new ContatoDAOImpl();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");

    public void limparCampos() { 
        nome.set("");
        telefone.set("");
        email.set("");
        id.set(0);
    }

    public Contato toEntity() { 
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setTelefone( telefone.get() );
        c.setEmail( email.get() );
        c.setId( id.get() );
        return c;
    }

    public void fromEntity(Contato c) { 
        telefone.set(c.getTelefone());
        nome.set(c.getNome());
        email.set(c.getEmail());
        id.set(c.getId());
    }

    public void gravar() { 
        Contato c = toEntity();
        if (c.getId() != 0) { 
            dao.atualizar(id.get(), c);
        } else { 
            dao.adicionar(c);
        }
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
        dao.excluir( c );
        pesquisarTodos();
    }

    public void pesquisarTodos() { 
        List<Contato> tempLista = dao.pesquisarTodos();
        lista.clear();
        lista.addAll( tempLista );
    }

    public void atualizar() { 
        Contato c = new Contato();
        c.setNome("Camila Vilares");
        c.setTelefone("4444444");
        c.setEmail("camila@teste.com");
        dao.atualizar(3, c);
    }

    public void novo() { 
        limparCampos();
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
