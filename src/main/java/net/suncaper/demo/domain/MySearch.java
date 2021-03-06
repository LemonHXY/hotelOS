package net.suncaper.demo.domain;

public class MySearch {

    private String city;
    private String name;
    private String start;
    private String end;
    private double longitude=116.331398;
    private double latitude=39.897445;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public MySearch(String city, String name, String start, String end) {
        this.city = city;
        this.name = name;
        this.start = start;
        this.end = end;
    }
    public MySearch() {
        super();
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }


}
