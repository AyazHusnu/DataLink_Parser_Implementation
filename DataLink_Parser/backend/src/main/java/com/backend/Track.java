package com.backend;

public class Track {

    private int trackID;
    private int trackHeading;
    private int trackSpeed;
    private short trackLatitude;
    private short trackLongitude;

    public Track(int id, int heading, int speed, short latitude, short longitude) {
        this.trackID = id;
        this.trackHeading = heading;
        this.trackSpeed = speed;
        this.trackLatitude = latitude;
        this.trackLongitude = longitude;

        //WRITE CREDENTIALS

        System.out.println("TRACK ID: " + this.trackID);
        System.out.println("TRACK HEADING: " + this.trackHeading);
        System.out.println("TRACK SPEED: " + this.trackSpeed);
        System.out.println("TRACK LATITUDE: " + this.trackLatitude);
        System.out.println("TRACK LONGITUDE: " + this.trackLongitude);
    }

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