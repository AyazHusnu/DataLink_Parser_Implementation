package com.backend;

import java.io.UnsupportedEncodingException;

public class DataParser {
    
    public TrackCredentials parse(String binaryData) throws UnsupportedEncodingException {

        TrackCredentials credentials = new TrackCredentials();
        
        //System.out.println(binaryData);
        
        credentials.set_trackID(Integer.parseInt(binaryData.substring(0, 8), 2));
        credentials.set_trackHeading(Integer.parseInt(binaryData.substring(8, 16), 2));
        credentials.set_trackSpeed(Integer.parseInt(binaryData.substring(16, 32), 2));
        credentials.set_trackLatitude((short) Integer.parseUnsignedInt(binaryData.substring(32, 48), 2));
        credentials.set_trackLongitude((short) Integer.parseUnsignedInt(binaryData.substring(48, 64), 2));

        return credentials;
    }
}