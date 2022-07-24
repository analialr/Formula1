package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import com.ironhack.edgeservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class EdgeControllerImpl implements EdgeController {

    @Autowired
    private UserService userService;

    @Autowired
    private EdgeService edgeService;
}
