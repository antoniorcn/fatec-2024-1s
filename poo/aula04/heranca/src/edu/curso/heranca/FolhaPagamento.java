package edu.curso.heranca;

public class FolhaPagamento {

    private Funcionario f1;
    private Funcionario f2;
    private Funcionario f3;

    public void pagar() {
        f1.receberPagamento(1350);
        f2.receberPagamento(1350);
        f3.receberPagamento(1350);
    }

    public Funcionario getF1() {
        return f1;
    }
    public void setF1(Funcionario f1) {
        this.f1 = f1;
    }

    public Funcionario getF2() {
        return f2;
    }
    public void setF2(Funcionario f2) {
        this.f2 = f2;
    }

    public Funcionario getF3() {
        return f3;
    }
    public void setF3(Funcionario f3) {
        this.f3 = f3;
    }
}
