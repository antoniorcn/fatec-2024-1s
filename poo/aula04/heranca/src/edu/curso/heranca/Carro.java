package edu.curso.heranca;

public class Carro extends Automovel {

    public Carro() {
        super();
        System.out.println("Instanciando um Carro");
    }
    private double tamanhoPortaMalas;

    public double getTamanhoPortaMalas() {
        return this.tamanhoPortaMalas;
    }
    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }
}
