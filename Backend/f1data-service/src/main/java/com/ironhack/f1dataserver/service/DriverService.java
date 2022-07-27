package com.ironhack.f1dataserver.service;

import com.ironhack.f1dataserver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

   @Autowired
   DriverRepository driverRepository;

}
