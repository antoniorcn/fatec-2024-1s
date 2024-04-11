import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ContatoControl { 
    StringProperty nome = new SimpleStringProperty("");
    StringProperty telefone = new SimpleStringProperty("");

    private ObservableList<Contato> lista = 
            FXCollections.observableArrayList();

    public void salvar() { 
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setTel( telefone.get() );
        lista.add(c);
        nome.set("");
        telefone.set("");
    }

    public void pesquisar() { 
        for( Contato c : lista) { 
            if (c.getNome().contains(nome.get())) { 
                nome.set(c.getNome());
                telefone.set(c.getTel());
            }
        }
    }

    public ObservableList<Contato> getLista() { 
        return lista;
    }
}