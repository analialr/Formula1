package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.RoleDTO;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.controller.dto.FollowDTO;
import com.ironhack.edgeservice.controller.interfaces.UserController;
import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.Role;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.store(userDTO);
    }

    @PostMapping("/users/{userId}/follows/{driverId}")
    @ResponseStatus(HttpStatus.CREATED)
    public FollowDTO follow(@PathVariable Long userId, @PathVariable String driverId) {
        return userService.follow(userId, driverId);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO login(@AuthenticationPrincipal User user) {
        log.info("Login successful");
        user.setPassword(null); // NEVER RETURN PASSWORD
        return userToDTO(user);
    }

    private UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));

        return userDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());

        return roleDTO;
    }

}
