public class TesteDAO { 

    public static void main(String args[]) { 
        ContatoDAO dao = new ContatoDAOImpl();

        Contato c = new Contato();
        c.setNome("Camila Pitanga");
        c.setTelefone("(11) 4444-4444");
        c.setEmail("camila@teste.com");

        dao.adicionar( c );
    }
}