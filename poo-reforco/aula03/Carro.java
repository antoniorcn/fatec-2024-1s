import java.util.ArrayList;
import java.util.List;

public class Carro {
    String marca = "";
    String modelo = "";
    String placa = "";
    int ano;
    List<Pneu> pneus = new ArrayList<>();
    private Motor motor = new Motor();

    private class Banco { 
        int altura;
    }

    Banco b1 = new Banco();
}
