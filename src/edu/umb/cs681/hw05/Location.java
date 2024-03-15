package edu.umb.cs681.hw05;

public class Location {
    private final double latitude;
    private final double longitude;
    private final String name;

    public Location(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", latitude, longitude);
    }
}
