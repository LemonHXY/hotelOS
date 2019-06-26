package net.suncaper.demo.service;

import net.suncaper.demo.domain.Customer;
import net.suncaper.demo.domain.CustomerExample;
import net.suncaper.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findUser(String name) {
        CustomerExample example = new CustomerExample();
        if(name != null && !name.equals("")) {
            example.createCriteria().andNameLike("%" + name + "%");
        }

        return customerMapper.selectByExample(example);
    }

    @Override
    public void saveCustomer(Customer customer) {

      //  if(customer.getId() == null || customer.getId().equals("")) {
            customerMapper.insert(customer);
   //     } else {
   //         customerMapper.updateByPrimaryKey(customer);
  //      }
    }

    @Override
    public void deleteUserById(int id) {
        customerMapper.deleteByPrimaryKey(id);
    }


    public Customer findUserById(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }
}
