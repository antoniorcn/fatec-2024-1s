package edu.curso.heranca;
public class Empresa {
    public static void main(String[] args) {
        Funcionario joao = new Funcionario();
        Funcionario maria = new Funcionario();
        Funcionario alberto = new Funcionario();

        FolhaPagamento fp = new FolhaPagamentoNova();
        fp.setF1(joao);
        fp.setF2(maria);
        fp.setF3(alberto);

        fp.pagar();
    }
}
