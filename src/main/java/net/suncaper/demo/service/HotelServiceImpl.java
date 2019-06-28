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
public  class HotelServiceImpl implements HotelService {
@Autowired
    private HotelMapper hotelmapper;
    @Autowired
    private CityMapper citymapper;
    @Override
    public List<Hotel> findHotelByCityId(int city) {
        HotelExample excample=new HotelExample();
        excample.createCriteria().andCityIdEqualTo(city);
       return  hotelmapper.selectByExample(excample);
    }

    @Override
    public City finCityByString(String name) {

    return citymapper.findBySting(name);

    }

    @Override
    public List<Hotel> findByCityAndName(String city, List<String> stringList) {
        City c=citymapper.findBySting(city);
        HotelExample example=new HotelExample();
        if(c!=null){
            example.createCriteria().andCityIdEqualTo(c.getCityId());
            example.isDistinct();
            for(int i=0;i<stringList.size();++i)
            {
                example.or().andHotelNameLike(stringList.get(i));
               // example.createCriteria().andHotelNameGreaterThanOrEqualTo(stringList.get(i));
            }
        }
        else {
            example.clear();
        }
        List<Hotel> result= hotelmapper.selectByExample(example);

        return result;
    }
}