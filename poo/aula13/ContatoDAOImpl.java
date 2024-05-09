import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAOImpl implements ContatoDAO { 
    private static final String JDBC_URL = 
    "jdbc:mariadb://localhost:3306/poo?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";


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

    @Override
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

    @Override
    public List<Contato> pesquisarTodos(){
        List<Contato> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM contatos ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Select executado com sucesso");

            while (rs.next()) { 
                Contato c = new Contato();
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setId(rs.getLong("id"));
                lista.add(c);
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
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
                c.setId(rs.getLong("id"));
                lista.add(c);
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void excluir( Contato c ) {
        try {
            String sql = "DELETE FROM contatos "+
            "WHERE nome = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            int linhas = stmt.executeUpdate();
            System.out.println("Excluir executado com sucesso, foram " + 
            " afetadas " + linhas + " linhas");
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar( long id, Contato c ) { 
        try {
            String sql = "UPDATE contatos SET nome=?, telefone=?, email=? "+
            "WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            stmt.setLong(4, id);
            int linhas = stmt.executeUpdate();
            System.out.println("Atualização executada com sucesso, foram " + 
            " afetadas " + linhas + " linhas");
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }

}