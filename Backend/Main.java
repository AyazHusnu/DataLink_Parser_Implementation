import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
    
        server.start(5000);
        while(server.listen().equals("-Q") == false);
        server.stop();
    }
}
