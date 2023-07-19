package com.vastracart.login.service;

import com.vastracart.login.Entity.Login;

import java.sql.SQLException;

public interface LoginServiceInt {

    public String saveuserLogin(Login login) throws SQLException;
}
