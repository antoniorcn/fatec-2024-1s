import java.time.LocalDate;

public class Aluno {
    private String nome;
    private String ra;
    private LocalDate nascimento;
    private double media;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public double getMedia() {
        return media;
    }
    public void setMedia(double media) {
        this.media = media;
    }    
}
