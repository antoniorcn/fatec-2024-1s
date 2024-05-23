import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o servidor de destino: ");
        String destino = scan.nextLine();
        System.out.println("Informe a porta de comunicação: ");
        int porta = scan.nextInt();

        try (Socket cliente = new Socket(destino, porta)) {
            System.out.println("Conectado no servidor");
            OutputStream out = cliente.getOutputStream();
            InputStream in = cliente.getInputStream();
            InputStream inTeclado = System.in;
            while (true) {
                if (in.available() > 0) {
                    int i = in.read();
                    System.out.print((char)i);
                }
                if (inTeclado.available() > 0) {
                    int i = inTeclado.read();
                    out.write(i);
                    out.flush();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
