package net.suncaper.demo.service;


import net.suncaper.demo.domain.City;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.HotelExample;
import net.suncaper.demo.mapper.CityMapper;
import net.suncaper.demo.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelmapper;
    @Autowired
    private CityMapper citymapper;

    @Override
    public List<Hotel> findHotelByCityId(int city) {
        HotelExample excample = new HotelExample();
        excample.createCriteria().andCityIdEqualTo(city);
        return hotelmapper.selectByExample(excample);
    }

    @Override
    public City finCityByString(String name) {
        return citymapper.findBySting(name);

    }
}