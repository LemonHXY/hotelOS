package net.suncaper.demo.service;

import net.suncaper.demo.domain.Hotel;

import java.util.List;


public interface HotelService {
     public List<Customer> findUser(String name);

     void saveCustomer(Customer customer);

     void deleteUserById(int id);

     public Customer findUserById(int id);
}
