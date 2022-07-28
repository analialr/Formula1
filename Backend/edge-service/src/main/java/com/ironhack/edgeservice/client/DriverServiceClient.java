package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.classes.Driver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("f1data-service")
public interface DriverServiceClient {

    @GetMapping("/drivers")
    public List<Driver> findAll();

    @GetMapping("/drivers/{driverId}")
    public Driver findById(@PathVariable String driverId);

}
