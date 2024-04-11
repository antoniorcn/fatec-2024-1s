import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {
    private ObservableList<Aluno> lista = 
        FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty ra = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = 
                new SimpleObjectProperty<>(LocalDate.now());
    private DoubleProperty media = new SimpleDoubleProperty(0.0);

    public void limparCampos() { 
        ra.set("");
        nome.set("");
        nascimento.set(LocalDate.now());
        media.set(0.0);
    }

    public Aluno toEntity() { 
        Aluno a = new Aluno();
        a.setRa( ra.get() );
        a.setNome( nome.get() );
        a.setNascimento( nascimento.get() );
        a.setMedia( media.get() );
        return a;
    }

    public void fromEntity(Aluno a) { 
        nome.set(a.getNome());
        ra.set(a.getRa());
        nascimento.set(a.getNascimento());
        media.set(a.getMedia());
    }

    public void gravar() { 
        Aluno a = toEntity();
        lista.add(a);
        limparCampos();
    }

    public void pesquisar() { 
        for (Aluno a : lista) { 
            if (a.getNome().contains( nome.get() )) { 
                fromEntity(a);
            }
        }
    }

    public ObservableList<Aluno> getLista() {
        return this.lista;
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public StringProperty raProperty() { 
        return this.ra;
    }

    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return this.nascimento;
    }

    public DoubleProperty mediaProperty() { 
        return this.media;
    }
    
}
