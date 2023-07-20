package com.backend;

public class TrackCredentials {

    private int trackID;
    private int trackHeading;
    private int trackSpeed;
    private short trackLatitude;
    private short trackLongitude;

    public int get_trackID() {
        return trackID;
    }

    public void set_trackID(int id) {
        this.trackID = id;
    }

    public int get_trackHeading() {
        return trackHeading;
    }

    public void set_trackHeading(int heading) {
        this.trackHeading = heading;
    }
    
    public int get_trackSpeed() {
        return trackSpeed;
    }

    public void set_trackSpeed(int speed) {
        this.trackSpeed = speed;
    }

    public short get_trackLatitude() {
        return trackLatitude;
    }

    public void set_trackLatitude(short latitude) {
        this.trackLatitude = latitude;
    }

    public short get_trackLongitude() {
        return trackLongitude;
    }

    public void set_trackLongitude(short longitude) {
        this.trackLongitude = longitude;
    }
}