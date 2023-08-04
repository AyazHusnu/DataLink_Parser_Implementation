package com.backend;
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private static String msg;
    private int waitingSecs = 5;

    public void start(int port) throws IOException{
        System.out.println("--------SERVER STARTED--------");
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(waitingSecs * 1000);
    }

    public String listen() throws IOException {
        clientSocket = serverSocket.accept();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        msg = in.readLine();
        in.close();
        
        clientSocket.close();
        return msg;
    }

    public void stop() throws IOException {
        System.out.println("--------SERVER CLOSED--------");
        serverSocket.close(); // Closes server edge
    }
}
