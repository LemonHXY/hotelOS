package net.suncaper.demo.service;

import net.suncaper.demo.domain.User;

import java.util.List;


public interface UserService {
     public List<User> findUser(String uid);

     void saveUser(User customer);

     void deleteUserById(int id);

     public User findUserByUIid(int id);
}
