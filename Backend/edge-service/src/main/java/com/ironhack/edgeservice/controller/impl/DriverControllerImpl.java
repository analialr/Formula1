package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.classes.Driver;
import com.ironhack.edgeservice.client.DriverServiceClient;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.controller.interfaces.DriverController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class DriverControllerImpl implements DriverController {

    @Autowired
    private DriverServiceClient driverServiceClient;

    @GetMapping("/drivers")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> findAll() {
        return driverServiceClient.findAll();
    }


}
