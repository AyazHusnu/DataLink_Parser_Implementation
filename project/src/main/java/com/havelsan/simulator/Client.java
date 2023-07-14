package com.havelsan.simulator;

import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    //private BufferedReader in;

    public void startConnection(String ip, int port){
        try {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch (ConnectException e){
            System.out.println("The server has not been started yet!");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void sendMessage(String msg) throws IOException{
        out.println(msg);
    }

    public void stopConnection() throws IOException{
        //in.close();
        out.close();
        clientSocket.close();
    }
}
