import java.util.List;
public interface ContatoDAO { 

    public void adicionar(Contato c);
    public List<Contato> pesquisarPorNome(String nome);
    public List<Contato> pesquisarTodos();
    public void excluir( Contato c ); 
    public void atualizar( long id, Contato c );

}