package net.suncaper.demo.service;

import net.suncaper.demo.domain.Guest;
import net.suncaper.demo.domain.User;

import java.util.List;


public interface UserService {

     public List<User> findUser(int uid);//通过id寻找一列用户

     void saveUser(User customer);//保存用户信息的  id name password

     void deleteUserById(int id);
     //通过id删除用户  该函数并未完善 后期徐亚同时删除  order guest user

     public User findUserByUIid(int id);//通过uid寻找户

     public List<Guest> findGuest(User user);//寻找某uid的同伴guest 的信息列表
}
