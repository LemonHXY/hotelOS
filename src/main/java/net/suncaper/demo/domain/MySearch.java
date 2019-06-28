package net.suncaper.demo.domain;

import java.sql.Date;

public class MySearch {

    private String city;
    private String name;
    private Date start;
    private Date end;

    public MySearch(String city, String name, Date start, Date end) {
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

    public void setrStart(java.util.Date rDate) {
        this.start = new Date(rDate.getTime());
    }

    public void setrEnd(java.util.Date rDate) {
        this.end = new Date(rDate.getTime());
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

}
