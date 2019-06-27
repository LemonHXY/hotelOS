package net.suncaper.demo.service;

import net.suncaper.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LogInService {

    void saveUser(User user);

    List<User> findUser(String name);
}