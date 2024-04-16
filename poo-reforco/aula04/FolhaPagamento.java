public class FolhaPagamento {
    public void pagar( float valor, Trabalhador t ) { 
        t.receberPagamento(valor * 1.10f);
    }
}
