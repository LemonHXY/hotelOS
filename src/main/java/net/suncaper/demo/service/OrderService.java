package net.suncaper.demo.service;

import net.suncaper.demo.domain.R_order;

import java.util.List;


public interface OrderService {
     public List<Customer> findUser(String name);

     void saveCustomer(Customer customer);

     void deleteUserById(int id);

     public Customer findUserById(int id);
}
