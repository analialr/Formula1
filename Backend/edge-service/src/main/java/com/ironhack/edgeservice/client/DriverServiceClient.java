package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.classes.Driver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@FeignClient("f1data-service")
public interface DriverServiceClient {

    @GetMapping("/drivers")
    public List<Driver> findAll();

    @GetMapping("/drivers/{driverId}")
    public Driver findById(@PathVariable String driverId);

}
