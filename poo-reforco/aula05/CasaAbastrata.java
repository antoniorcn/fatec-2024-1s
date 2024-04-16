public abstract class CasaAbstrata { 

    public void abrirPorta();

    public void abrirJanela();

}

class CasaPreFabricada extends CasaAbstrata { 
    public void abrirPorta() { 
        System.out.println("Porta aberta");
    }

    public void abrirJanela() { 
        System.out.println("Janela aberta");
    }
}