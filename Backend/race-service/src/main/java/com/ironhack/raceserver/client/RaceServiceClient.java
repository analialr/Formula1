package com.ironhack.raceserver.client;

import com.ironhack.raceserver.classes.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="race-client", url="http://ergast.com/api/f1")
public interface RaceServiceClient {
    @GetMapping("/current/last/results.json")
    public ResponseDTO getLastRace();
}
