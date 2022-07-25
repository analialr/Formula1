package com.ironhack.edgeservice.controller.interfaces;


import com.ironhack.edgeservice.controller.dto.FollowDTO;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserController {
    UserDTO register(UserDTO userDTO);
    List<UserDTO> findAll();
    UserDTO login(User user);
    FollowDTO follow(Long userId, String driverId);
}
