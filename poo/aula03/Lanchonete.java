public class Lanchonete { 
    public static void main(String [] args) {
        MeioPagamento debito = 
            new MeioPagamento("Debito", 0.01);
        MeioPagamento dinheiro = 
            new MeioPagamento("Dinheiro", 0.0);
        MeioPagamento credito = 
            new MeioPagamento("Crédito", 0.05); 

        Cliente joao = new Cliente("João Silva");
        joao.pagamento = credito;
        Cliente maria = new Cliente("Maria Silva");
        maria.pagamento = dinheiro;

        Produto p1 = new Produto("Coxinha", 8.0, 10.0);
        Produto p2 = new Produto("Pão de Queijo", 8.0, 5.0);
        Produto p3 = new Produto("Coca cola", 4.0, 20.0);

        Venda v1 = new Venda();
        v1.cliente = joao;
        v1.produto = p2;
        v1.qtd = 2;
        v1.valor = 8.0;
        v1.valorTotal = vq.qtd * v1.valor;

        Venda v2 = new Venda();
        v1.cliente = maria;
        v1.produto = p3;
        v1.qtd = 1;
        v1.valor = 4.0;
        v1.valorTotal = vq.qtd * v1.valor;
    }
}