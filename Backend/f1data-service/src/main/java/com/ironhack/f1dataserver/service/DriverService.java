package com.ironhack.f1dataserver.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ironhack.f1dataserver.model.Driver;
import com.ironhack.f1dataserver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DriverService {

   @Autowired
   DriverRepository driverRepository;

}
