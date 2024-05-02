import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteDataBase { 

    private static final String JDBC_URL = 
    "jdbc:mariadb://localhost:3306/agenda";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "alunofatec";


    public static void insert(Connection con) throws SQLException { 
        String sql = "INSERT INTO contatos (nome, telefone, email) "+
        "VALUES ('Joao Silva', '(11) 111-111', 'joao@teste.com')";

        PreparedStatement stmt = con.prepareStatement(sql);
        int linhas = stmt.executeUpdate();
        System.out.println("Insert executado com sucesso, foram " + 
        " afetadas " + linhas + " linhas");
    }

    public static void delete(Connection con) throws SQLException { 
        String sql = "DELETE FROM contatos";

        PreparedStatement stmt = con.prepareStatement(sql);
        int linhas = stmt.executeUpdate();
        System.out.println("Delete executado com sucesso, foram " + 
        " afetadas " + linhas + " linhas");
    }

    public static void select(Connection con) throws SQLException { 
        String sql = "SELECT * FROM contatos";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Select executado com sucesso");

        while (rs.next()) { 
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");

            System.out.printf("Nome: %s\tTelefone: %s\tEmail: %s%n", 
                nome, telefone, email);           
        }
    }


    public static void main(String args[]) { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado");
            Connection con = 
            DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado ao banco de dados com sucesso");

            select( con );

            con.close();
        } catch (ClassNotFoundException e) { 
            System.out.println("Classe do database não encontrada");
            e.printStackTrace();
        } catch (SQLException e) { 
            System.out.println("Erro de conexão ao banco de dados");
            e.printStackTrace();
        }
    }
}