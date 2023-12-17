package edu.umb.cs680.hw06;

class Location {
    private double latitude;        //Coordinates
    private double longitude;       //Coordinates

    public Location(double latitude, double longitude) {        //Parameterized Constructor
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {       //Getter for Latitude
        return latitude;
    }

    public double getLongitude() {      //Getter for Latitude
        return longitude;
    }
}