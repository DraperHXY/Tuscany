package com.draper.tuscany_service_second.mapper;


import com.draper.tuscany_core.model.User;

public interface UserMapper {

    void insertByPhone(User user);

    void insertByEmail(User user);

    User selectByPhone(String phone);

    User selectByEmail(String email);

}
