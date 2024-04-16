public class Empresa {
    public static void main(String[] args) {
        Trabalhador joao = new Trabalhador();
        Trabalhador maria = new Trabalhador();

        FolhaPagamento fp = new FolhaPagamentoPlus();

        fp.pagar(1500, joao);
        fp.pagar(1500, maria);

    }
}
