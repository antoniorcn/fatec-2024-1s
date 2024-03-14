public class Calculadora {
    private long display = 0;
    private long numeroAntigo = 0;

    public native void imprimirImpressora(String texto);

    public void alterarDisplay(long valor) {
        numeroAntigo = display;
        display = valor;
    }

    public void somar() {
        alterarDisplay(numeroAntigo + display);
    }

    public long pegarResultado() {
        return display;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        calc.alterarDisplay(100);
        calc.alterarDisplay(200);
        calc.somar();
        System.out.println(calc.pegarResultado());

    }

}
