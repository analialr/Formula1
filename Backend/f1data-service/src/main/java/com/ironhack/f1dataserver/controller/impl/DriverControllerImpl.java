package com.ironhack.f1dataserver.controller.impl;

import com.ironhack.f1dataserver.controller.interfaces.DriverController;
import com.ironhack.f1dataserver.model.Driver;
import com.ironhack.f1dataserver.repository.DriverRepository;
import com.ironhack.f1dataserver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DriverControllerImpl implements DriverController {

    @Autowired
    public DriverRepository driverRepository;

    @Autowired
    public DriverService driverService;

    @GetMapping("/drivers")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{driverId}")
    @ResponseStatus(HttpStatus.OK)
    public Driver findById(@PathVariable String driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);
        return driver.isPresent() ? driver.get() : null;
    }


}
