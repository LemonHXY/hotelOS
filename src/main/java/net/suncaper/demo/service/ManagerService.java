package net.suncaper.demo.service;

import net.suncaper.demo.domain.Manager;

import java.util.List;


public interface ManagerService {
     public List<Customer> findUser(String name);

     void saveCustomer(Customer customer);

     void deleteUserById(int id);

     public Customer findUserById(int id);
}
