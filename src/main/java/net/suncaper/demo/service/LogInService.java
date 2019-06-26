package net.suncaper.demo.service;

import net.suncaper.demo.domain.User;

import java.util.List;

public interface LogInService {

    void saveUser(User user);

    public List<User> findUser(String name);
}
