package com.ironhack.userserver.service.interfaces;

import com.ironhack.edgeservice.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO store(UserDTO user);
    List<UserDTO> findAll();
}
