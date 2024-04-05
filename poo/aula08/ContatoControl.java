import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContatoControl { 
    StringProperty nome = new SimpleStringProperty("");
    StringProperty telefone = new SimpleStringProperty("");

    private List<Contato> lista = new ArrayList<>();

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
}