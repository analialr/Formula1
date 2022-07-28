package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.RaceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("race-service")
public interface RaceServiceClient {
    @GetMapping("/races/last")
    public RaceDTO getLastRace();
}
