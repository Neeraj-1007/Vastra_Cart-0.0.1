package com.vastracart.login.controller;


import com.vastracart.login.Entity.Login;
import com.vastracart.login.service.LoginServiceInt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceInt loginServiceInt;

    @PostMapping("/save")
    public String saveuserLogin(@RequestBody Login login) throws SQLException {

      String result=  loginServiceInt.saveuserLogin(login);
      return  result;

    }
}
