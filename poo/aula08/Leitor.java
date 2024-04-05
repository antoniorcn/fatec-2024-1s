public class Leitor implements Assinante { 
    private String nome = "";
    public Leitor(String nome) { 
        this.nome = nome;
    }

    public void receberNotificacao( String noticia ) { 
        System.out.println(this.nome + " lendo a noticia: " + noticia);
    }

}