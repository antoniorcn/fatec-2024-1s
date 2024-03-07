package edu.curso.heranca;

public class Automovel extends Produto {

    public Automovel(String nome) {
        super(nome);
        System.out.println("Instanciando um Automovel");
    }
    public Automovel() {
        this("Generico");
    }

    private String chassi = "";

    public String getChassi() {
        return this.chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
