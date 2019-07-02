package net.suncaper.demo.domain;

import java.util.Date;

public class MySearch {

    private String city;
    private String name;

    private String start;

    private Date end;

    public MySearch(String city, String name, String start, Date end) {
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

    public void setrStart(String rDate) {
        this.start =  rDate;
    }

    public void setrEnd(Date rDate) {
        this.end = rDate;
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

    public Date getEnd() {
        return end;
    }

}
