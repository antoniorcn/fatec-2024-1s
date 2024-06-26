import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAOImpl implements ContatoDAO { 
    private static final String JDBC_URL = 
    "jdbc:mariadb://localhost:3306/agenda?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "alunofatec";


    private Connection con;
    public ContatoDAOImpl() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado");
            con = 
            DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Conectado ao banco de dados com sucesso");
        } catch (ClassNotFoundException e) { 
            System.out.println("Classe do database não encontrada");
            e.printStackTrace();
        } catch (SQLException e) { 
            System.out.println("Erro de conexão ao banco de dados");
            e.printStackTrace();
        }
    }

    public void adicionar(Contato c){
        try {
            String sql = "INSERT INTO contatos (nome, telefone, email) "+
            "VALUES (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            int linhas = stmt.executeUpdate();
            System.out.println("Insert executado com sucesso, foram " + 
            " afetadas " + linhas + " linhas");
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }

    public List<Contato> pesquisarPorNome(String nome){
        List<Contato> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM contatos " + 
                            "WHERE nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Select executado com sucesso");

            while (rs.next()) { 
                Contato c = new Contato();
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

}