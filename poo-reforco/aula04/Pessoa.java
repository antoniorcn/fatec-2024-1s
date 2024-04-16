public class Pessoa extends Animal {
    public String nome;
    public Pessoa(String nome) { 
        super();
        this.nome = nome;
        System.out.println("Instanciando Pessoa");
    }

    public Pessoa() { 
        this("Desconhecido");
        System.out.println("Instanciando Anonimo");
    }
}
