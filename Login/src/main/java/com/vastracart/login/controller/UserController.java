package com.vastracart.login.controller;


import com.vastracart.login.Entity.User;
import com.vastracart.login.Entity.UserRequest;
import com.vastracart.login.Entity.UserResponse;
import com.vastracart.login.config.JwtUtil;
import com.vastracart.login.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserServiceInt userService;

    @Autowired
    private JwtUtil util;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user) {
        System.out.println("in save method");
        Integer id = userService.saveUser(user);

        String body = "User " + id + " saved";
        return ResponseEntity.ok(body);
    }

    // validate user and generate token

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
        String token = util.generateToken(userRequest.getUserName());
        return ResponseEntity.ok(new UserResponse("Success!!", token));

    }

    @PostMapping("/welcome")
    public ResponseEntity<String> accessData(Principal p) {
        return ResponseEntity.ok("Hello Brother  "+p.getName());
    }

}
