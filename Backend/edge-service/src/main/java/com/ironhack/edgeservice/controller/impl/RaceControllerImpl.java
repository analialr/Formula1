package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.classes.Driver;
import com.ironhack.edgeservice.client.DriverServiceClient;
import com.ironhack.edgeservice.client.RaceServiceClient;
import com.ironhack.edgeservice.controller.dto.RaceDTO;
import com.ironhack.edgeservice.controller.interfaces.RaceController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class RaceControllerImpl implements RaceController {

    @Autowired
    private RaceServiceClient raceServiceClient;

    @GetMapping("/races/last")
    @ResponseStatus(HttpStatus.OK)
    public RaceDTO getLastRace() {
        return raceServiceClient.getLastRace();
    }


}
