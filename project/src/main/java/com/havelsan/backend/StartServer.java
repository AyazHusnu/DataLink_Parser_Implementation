package com.havelsan.backend;

import java.io.*;

public class StartServer {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
    
        server.start(5000);
        while(server.listen().equals("0000000000000000000000000000000000000000000000000000000000000000") == false);
        server.stop();
    }
}
