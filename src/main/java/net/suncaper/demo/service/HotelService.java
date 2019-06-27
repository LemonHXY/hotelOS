package net.suncaper.demo.service;

import net.suncaper.demo.domain.Guest;
import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.User;

import java.util.List;


public interface HotelService {

    //public List<User> findUser(int uid);//通过id寻找一列用户

    void saveHotel(Hotel hotel);//保存用户信息的  id name password

    void deleteUserById(int hoteId);
    //通过id删除用户  该函数并未完善 后期徐亚同时删除  order guest user

    public User findUserByUIid(int hotelId);//通过uid寻找户

    public List<Guest> findHostel(Hotel hotel);//寻找某uid的同伴guest 的信息列表
}
