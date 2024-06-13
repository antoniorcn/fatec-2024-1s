package edu.curso;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.time.LocalDate;

public class AlunoControl { 
    private ObservableList<Aluno> lista = 
        FXCollections.observableArrayList();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty ra = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = 
        new SimpleObjectProperty(LocalDate.now());  
        
    private AlunoDAO alunoDao = null;
    
    public AlunoControl() throws AlunoException {
        try {  
            alunoDao = new AlunoDAOImpl();
        } catch(Exception e) { 
            throw new AlunoException(e);
        }
    }

    public void excluir(long id) throws AlunoException {
        alunoDao.remover(id);
    }

    public void adicionar() throws AlunoException {
        Aluno a = new Aluno();
        a.setId(id.get());
        a.setRa(ra.get());
        a.setNome(nome.get());
        a.setNascimento(nascimento.get());
        alunoDao.adicionar(a);
    }

    public void pesquisarPorNome() throws AlunoException {
        lista.clear();
        lista.addAll(alunoDao.pesquisarPorNome(nome.get()));
    }


    public ObservableList<Aluno> getLista() { 
        return lista;
    }

    public LongProperty idProperty() { 
        return id;
    }

    public StringProperty raProperty() { 
        return ra;
    }
    public StringProperty nomeProperty() { 
        return nome;
    }
    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return nascimento;
    }
}