import java.util.Scanner;
import java.util.List;

public class TesteDAOConsulta { 

    public static void main(String args[]) { 
        ContatoDAO dao = new ContatoDAOImpl();

        Scanner input = new Scanner(System.in);

        System.out.println("Informe o nome que deseja Procurar: ");
        String nome = input.nextLine();

        List<Contato> contatos = dao.pesquisarPorNome( nome );

        for (Contato c : contatos) { 
            System.out.println(c);
        }

        input.close();
    }
}