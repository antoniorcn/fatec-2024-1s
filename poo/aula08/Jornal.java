import java.util.List;
import java.util.ArrayList;

public class Jornal implements Publicador { 
    private List<Assinante> lista = new ArrayList<>();
    private String nome;
    Jornal(String nome) { 
        this.nome = nome;
    }

    @Override
    public void adicionar(Assinante a) { 
        lista.add(a);
    }

    @Override
    public void remover(Assinante a) { 
        lista.remove(a);
    }

    @Override
    public void notificar(String noticia) { 
        for (Assinante a : lista) { 
            a.receberNotificacao( this.nome + "informa: " + noticia );
        }
    }

}