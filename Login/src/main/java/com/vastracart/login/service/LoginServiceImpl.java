package com.vastracart.login.service;

import com.vastracart.login.Entity.Login;
import com.vastracart.login.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginServiceImpl implements LoginServiceInt {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public String saveuserLogin(Login login) throws SQLException {
        try {
            Login updatedLogin = loginRepo.save(login);
            if (updatedLogin != null) {
                return "SUCCESS";
            }else{
                throw new NullPointerException("Unable to Save the Entity");
            }
        }catch (Exception e){
           throw new SQLException("Unble to connect");
        }
    }
}
