package edu.curso.heranca;

public class FolhaPagamentoNova extends FolhaPagamento {

    @Override
    public void pagar() {
        getF1().receberPagamento(2000);
        getF2().receberPagamento(2000);
        getF3().receberPagamento(2000);
    }
}
