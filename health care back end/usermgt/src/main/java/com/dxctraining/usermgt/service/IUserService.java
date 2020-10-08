package com.dxctraining.usermgt.service;

import com.dxctraining.usermgt.entities.User;

import java.util.List;

public interface IUserService {
    User findById(int id);

    User findByUsername(String username);

    List<User> fetchAll();

    User save(User user);

    boolean credentialsCorrect(int id, String password);


    void remove(int id);
}
