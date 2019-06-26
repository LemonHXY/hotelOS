package net.suncaper.demo.service;

import net.suncaper.demo.domain.CustomerExample;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.domain.UserExample;
import net.suncaper.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServicelmpl implements LogInService {

    private UserMapper userMapper;

    public void saveUser(User user){
        userMapper.insert(user);
    }

    @Override
    public List<User> findUser(String name) {
        UserExample example = new UserExample();
        if(name != null && !name.equals("")) {
            example.createCriteria().andUNameLike("%" + name + "%");
        }
        return userMapper.selectByExample(example);
    }

}
