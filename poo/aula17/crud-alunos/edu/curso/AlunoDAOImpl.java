package edu.curso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

public class AlunoDAOImpl implements AlunoDAO { 
    private DBConnection dbConn = null;

    public AlunoDAOImpl() throws AlunoException { 
        try { 
            dbConn = DBConnection.getInstance();
        } catch (Exception e) { 
            throw new AlunoException( e );
        }
    }

    public void adicionar(Aluno a) throws AlunoException {
        try { 
            Connection con = dbConn.getConnection();
            String sql = """
                INSERT INTO alunos(ra, nome, nascimento) VALUES (?, ?, ?)
            """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getRa());
            pstm.setString(2, a.getNome());
            pstm.setDate(3, java.sql.Date.valueOf(a.getNascimento()));
            pstm.executeUpdate();
            con.close();
        } catch (Exception e) { 
            throw new AlunoException( e );
        }
    }

    public List<Aluno> pesquisarTodos() throws AlunoException { 
        return pesquisarPorNome("");
    }

    public List<Aluno> pesquisarPorNome(String nome) throws AlunoException { 
        try { 
            List<Aluno> lista = new ArrayList<Aluno>();
            Connection con = dbConn.getConnection();
            String sql = """
                SELECT * FROM alunos WHERE nome LIKE ?
            """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) { 
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setRa(rs.getString("ra"));
                a.setNome(rs.getString("nome"));
                a.setNascimento(rs.getDate("nascimento").toLocalDate());
                lista.add(a);
            }
            con.close();
            return lista;
        } catch (Exception e) { 
            throw new AlunoException( e );
        }            
    }
    public void remover(long id) throws AlunoException {
        try {
            Connection con = dbConn.getConnection();
            String sql = """
                DELETE FROM alunos WHERE id = ?)
            """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            con.close();
        } catch (Exception e) { 
            throw new AlunoException( e );
        }            
    }

    public void atualizar(long id, Aluno a) throws AlunoException {
        try { 
            Connection con = dbConn.getConnection();
            String sql = """
                UPDATE alunos SET ra = ?, nome = ?, nascimento = ?
                WHERE id = ?
            """;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getRa());
            pstm.setString(2, a.getNome());
            pstm.setDate(3, java.sql.Date.valueOf(a.getNascimento()));
            pstm.setLong(4, id);
            pstm.executeUpdate();
            con.close();
        } catch (Exception e) { 
            throw new AlunoException( e );
        }            
    }
}