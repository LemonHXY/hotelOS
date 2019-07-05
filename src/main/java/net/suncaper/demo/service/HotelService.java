package net.suncaper.demo.service;

import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;

import java.util.List;


public interface HotelService {
    public List<Hotel> findHotelByCityId(int city);

    public Hotel findHotelByKey(int hotelId);

    public City finCityByString(String name);

    public List<Hotel> findByCityAndName(String city, List<String> stringList);

}
