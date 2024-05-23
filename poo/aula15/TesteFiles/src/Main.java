import java.io.*;

class Aluno implements Serializable {
    int ra;
    String nome = "";
}

public class Main {

    public static void testeFileWrite(String nomeArquivo) {
        File f = new File(nomeArquivo);
        try (FileWriter fw = new FileWriter(f)) {
            String ENTER = Character.toString(0x000D);
            fw.write("Antonio" + ENTER );
            fw.write("João" + ENTER );
            fw.write("Maria" + ENTER );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testeFileReader( String nomeArquivo ) {
        File f = new File(nomeArquivo);

        try (FileReader fr = new FileReader(f)) {
            int i = 0;
            while ( (i = fr.read()) != -1 ) {
                System.out.print((char)i);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void testeGravacaoObjeto( String nomeArquivo, Aluno a ) {
        File f = new File(nomeArquivo);
        try (FileOutputStream fout = new FileOutputStream(f)) {
            ObjectOutputStream objWriter = new ObjectOutputStream(fout);
            objWriter.writeObject( a );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Aluno testeLeituraObjeto( String nomeArquivo ) {
        File f = new File(nomeArquivo);
        Aluno a1 = null;
        try (FileInputStream fin = new FileInputStream(f)) {
            ObjectInputStream objReader = new ObjectInputStream(fin);
            a1 = (Aluno) objReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return a1;
    }

    public static void main(String[] args) {
        // testeFileWrite("c:/temp/teste.txt");
//        Aluno a1 = new Aluno();
//        a1.ra = 112;
//        a1.nome = "João Silva";
//        testeGravacaoObjeto("c:/temp/aluno.dat", a1);

        Aluno a2 = testeLeituraObjeto("c:/temp/aluno.dat");
        System.out.println("RA: " + a2.ra);
        System.out.println("Nome: " + a2.nome);
    }
}