package net.suncaper.demo.service;

import net.suncaper.demo.domain.Room;

import java.util.List;


public interface RoomService {
     public List<Customer> findUser(String name);

     void saveCustomer(Customer customer);

     void deleteUserById(int id);

     public Customer findUserById(int id);
}
