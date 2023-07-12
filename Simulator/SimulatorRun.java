package Simulator;

import java.io.IOException;

public class SimulatorRun {
    public static void main(String[] args) throws IOException, NullPointerException{
        
        Client client = new Client();
        client.startConnection("127.0.0.1", 5000);
        client.sendMessage("-Q");
    }
}
