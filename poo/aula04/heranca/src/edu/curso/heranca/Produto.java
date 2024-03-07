package edu.curso.heranca;

public class Produto {

//    public Produto() {
//
//    }
    public Produto(String nome) {
        super();
        System.out.println("Instanciando um produto");
        this.titulo = nome;
    }

    private String titulo = "";
    private double valor = 0;

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

}
