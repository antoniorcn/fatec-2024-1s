import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteAluno { 
    public static void main(String[] args) {  

        Aluno joao = new Aluno();
        Aluno maria = new Aluno();

        ChangeListener<String> observador = new ChangeListener<>(){ 
            public void changed(ObservableValue<? extends String> prop, 
                String oldValue, String newValue) { 
                    System.out.println("Nome alterado de " + 
                    oldValue + " para " + newValue);
            }
        };

        joao.nomeProperty().addListener(observador);

        joao.setNome("Joao Silva");
        maria.setNome("Maria Silva");

        joao.setNome("Joao Santos");
        maria.setNome("Maria Santos");

    }
}