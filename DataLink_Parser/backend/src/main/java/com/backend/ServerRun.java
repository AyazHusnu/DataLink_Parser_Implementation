package com.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerRun {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        String binaryData;
        DataParser dataParser = new DataParser();
        TrackCredentials credentials = new TrackCredentials();
        List <Track> list_tracks = new ArrayList<Track>();
    
        server.start(5000);
        
        while(true) {

            try {
                binaryData = server.listen(); // Awaiting for simulator

                if (binaryData.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    break;
                }
                
                credentials = dataParser.parse(binaryData);

                Track track = new Track(
                    credentials.get_trackID(),
                    credentials.get_trackHeading(),
                    credentials.get_trackSpeed(),
                    credentials.get_trackLatitude(),
                    credentials.get_trackLongitude());
                
                list_tracks.add(track);
            } catch (java.net.SocketTimeoutException e) {
                System.out.println(e);
            }

        }
        
        server.stop();
    }
}
