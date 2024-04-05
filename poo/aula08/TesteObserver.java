public class TesteObserver { 

    public static void main(String args[]) { 
        Leitor jose = new Leitor("José");
        Leitor maria = new Leitor("Maria");
        Leitor joao = new Leitor("João");
        Leitor marta = new Leitor("Marta");

        Jornal folha = new Jornal("Folha de São Paulo");
        Jornal estadao = new Jornal("Estadão");

        folha.adicionar(jose);
        folha.adicionar(marta);

        estadao.adicionar(joao);
        estadao.adicionar(maria);

        estadao.notificar("Carro popular elétrico por menos 30 mil");
        folha.notificar("Alunos da Fatec Zona Leste ganham ingressos grátis para a Campus Party");


    }
}