package com.draper.tuscany_core.service;


import com.draper.tuscany_core.model.User;

public interface UserService {

    boolean insertUserByPhone(User user);

    boolean insertUserByEmail(User user);

    User selectUserByPhone(String phone);

    User selectUserByEmail(String email);

}
