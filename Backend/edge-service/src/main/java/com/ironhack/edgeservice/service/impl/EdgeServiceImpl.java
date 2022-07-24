package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeServiceImpl {

    @Autowired
    private UserService userService;

}
