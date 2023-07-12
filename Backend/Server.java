
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static String msg;

    public void start(int port) throws IOException{

        System.out.println("--------SERVER STARTED--------");

        serverSocket = new ServerSocket(port);
    }

    public String listen() throws IOException {
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        msg = in.readLine();
        
        if (msg.equals("-Q") == false) {
            System.out.println(msg);
        }

        in.close();
        out.close();

        clientSocket.close();

        return msg;
    }

    public void stop() throws IOException {
        System.out.println("--------SERVER CLOSED--------");
        serverSocket.close(); // Closes server edge
    }
}
