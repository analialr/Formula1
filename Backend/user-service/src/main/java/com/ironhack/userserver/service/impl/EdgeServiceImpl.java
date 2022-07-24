package com.ironhack.userserver.service.impl;

import com.ironhack.edgeservice.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeServiceImpl {

    @Autowired
    private UserServiceClient userServiceClient;

}
