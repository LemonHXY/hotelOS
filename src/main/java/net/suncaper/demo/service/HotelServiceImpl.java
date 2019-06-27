package net.suncaper.demo.service;


//import net.suncaper.demo.domain.Customer;
//import net.suncaper.demo.domain.CustomerExample;


import net.suncaper.demo.domain.*;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.Room_quantityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import net.suncaper.demo.mapper.CustomerMapper;
//import org.springframework.stereotype.server;

@Service
public  class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private Room_quantityMapper quantityMapper;


    @Override
    public void saveHotel(Hotel hotel) {

    }

    @Override
    public void deleteUserById(int hoteId) {

    }

    @Override
    public User findUserByUIid(int hotelId) {
        return null;
    }

    @Override
    public List<Guest> findHostel(Hotel hotel) {
        HotelExample hotelExample=new HotelExample() ;
        Room_quantityExample quantityExample=new Room_quantityExample();
        if(hotel.getCityId()!=null)
            hotelExample.createCriteria().andCityIdEqualTo(hotel.getCityId());
        if(hotel.getCheckin()!=null)

        return null;
    }
   /*
*//*    @Override
    public List<Hotel> findUser(int id) {
        UserExample example = new UserExample();
        if(id>0) {
            example.createCriteria().andUIdEqualTo(id);//Like("%" + name + "%");
        }
        return userMapper.selectByExample(example);
    }*//*

    @Override
    public void saveUser(User user) {
        if(user.getuId() == null || user.getuId()<0) {

        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findUserByUIid(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Guest> findGuest(User user){
        GuestExample example=new GuestExample();
        example.createCriteria().andUIdEqualTo(user.getuId());
        return guestMapper.selectByExample(example);
    }*/

}
