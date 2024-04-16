public class FolhaPagamentoPlus extends FolhaPagamento {
    @Override
    public void pagar(float valor, Trabalhador t) {
        t.receberPagamento(valor * 1.5f);
    }
    
}
