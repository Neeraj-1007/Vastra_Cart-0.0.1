package com.vastracart.login.service;

import com.vastracart.login.Entity.User;

import java.util.Optional;

public interface UserServiceInt {


    Integer saveUser(User user);

    Optional<User> findByUserName(String userName);
}
