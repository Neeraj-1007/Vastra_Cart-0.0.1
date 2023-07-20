package com.vastracart.controller;


import com.vastracart.entity.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@Slf4j
@RequestMapping("/root")
public class RootController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public String getSaveResult(@RequestBody Login login){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Login> entity = new HttpEntity<Login>(login,headers);

        return restTemplate.exchange(
                "http://localhost:8081/vastracart/login/save", HttpMethod.POST, entity, String.class).getBody();

    }

}
