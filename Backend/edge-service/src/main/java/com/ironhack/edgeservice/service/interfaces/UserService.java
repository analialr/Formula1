package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.User;

import java.util.List;

public interface UserService {
    UserDTO store(UserDTO user);
    Follow follow(Long userId, String driverId);
    List<UserDTO> findAll();
}
