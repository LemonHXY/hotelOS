package net.suncaper.demo.service;


//import net.suncaper.demo.domain.Customer;
//import net.suncaper.demo.domain.CustomerExample;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.domain.UserExample;
import net.suncaper.demo.domain.Guest;
import net.suncaper.demo.domain.GuestExample;
import net.suncaper.demo.mapper.GuestMapper;
import net.suncaper.demo.mapper.UserMapper;

//import net.suncaper.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.server;

import java.util.List;

@Service
public  class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GuestMapper guestMapper;

    @Override
    public List<User> findUser(String uid) {
        UserExample example = new UserExample();
        if(uid != null && !uid.equals("")) {
            example.createCriteria().andUIdEqualTo(uid);//Like("%" + name + "%");
        }

        return userMapper.selectByExample(example);
    }

    @Override
    public void saveUser(User user) {
        if(user.getuId() == null || user.getuId().equals("")) {

        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteUserById(String id) {
        userMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<Guest> findGuest(User user){
        GuestExample example=new GuestExample();
        example.createCriteria().andUIdEqualTo(user.getuId());
        return guestMapper.selectByExample(example);
    }



    public User findUserByUIid(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
