package net.suncaper.demo.service;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;

import java.util.List;


public interface HotelService {
    public List<Hotel> findHotelByCityId(int city);
    public City finCityByString(String name);
}
