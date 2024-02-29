public class Cliente { 

    public String nome;
    public MeioPagamento pagamento;
    private Documento documento = new Documento();

    public Cliente(String nome) { 
        this.nome = nome;
    }

}