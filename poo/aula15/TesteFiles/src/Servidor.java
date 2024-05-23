import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String[] args) {
        System.out.println("Programa iniciado");
        try (ServerSocket server = new ServerSocket(80)) {
            System.out.println("Servidor iniciado");
            System.out.println("Aguardando conexão do cliente");
            Socket soc = server.accept();
            System.out.println("Cliente conectado");

            OutputStream out = soc.getOutputStream();
            out.write("Bem vindo ao servidor de socket\n\r".getBytes());
            out.write("Digite algo para ser mostrado no servidor\n\r".getBytes());
            out.flush();

            InputStream in = soc.getInputStream();
            while( true ) {
                if (in.available() > 0) {
                    int i = in.read();
                    System.out.print((char)i);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
