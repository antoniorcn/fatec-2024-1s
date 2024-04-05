import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Aluno { 
    private StringProperty nome = new SimpleStringProperty("");

    public String getNome() { 
        return this.nome.get();
    }

    public void setNome(String valor) { 
        this.nome.set(valor);
    }

    public StringProperty nomeProperty() { 
        return nome;
    }
}