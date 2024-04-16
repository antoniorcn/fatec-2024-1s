public class Aluno extends Pessoa {
    
    public Aluno() { 
        super();
        System.out.println("Instanciando Aluno");
    }

    public void matricular() { 
        System.out.println("Matricula sem dados");
    }

    public void matricular(String documento) { 
        System.out.println("Matricula com documento");
    }

    public void matricular(String documento, int idade) { 
        System.out.println("Matricula com documento e idade");
    }

    @Override
    public void comer() { 
        System.out.println("Comendo como um Aluno...");
        throw new RuntimeException("teste");
    }
}
