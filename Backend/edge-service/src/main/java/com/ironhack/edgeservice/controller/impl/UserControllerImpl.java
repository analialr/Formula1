package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.classes.Driver;
import com.ironhack.edgeservice.client.DriverServiceClient;
import com.ironhack.edgeservice.controller.dto.RoleDTO;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.controller.dto.FollowDTO;
import com.ironhack.edgeservice.controller.interfaces.UserController;
import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.Role;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.repository.FollowRepository;
import com.ironhack.edgeservice.repository.UserRepository;
import com.ironhack.edgeservice.service.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Transactional
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private DriverServiceClient driverServiceClient;

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.store(userDTO);
    }

    @PostMapping("/users/{userId}/follows/{driverId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO follow(@PathVariable Long userId, @PathVariable String driverId) {
        User user = userRepository.findById(userId).get();
        Optional<Follow> existingFollow = followRepository.findByUserAndDriver(user, driverId);
        if (!existingFollow.isPresent()){
            userService.follow(userId, driverId);
            userRepository.save(user);
            entityManager.refresh(user);
        }

        return userToDTO(user);
    }

    @DeleteMapping("/users/{userId}/follows/{driverId}")
    @ResponseStatus(HttpStatus.OK)
    public void unfollow(@PathVariable Long userId, @PathVariable String driverId) {
        User user = userRepository.findById(userId).get();
        Follow follow = followRepository.findByUserAndDriver(user, driverId).get();
        followRepository.deleteById(follow.getId());
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
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));
        Set<Driver> drivers = new HashSet<>();
        for(Follow follow : user.getFollows()){
            drivers.add(driverServiceClient.findById(follow.getDriver()));
        }
        userDTO.setFollows(drivers);
        return userDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());

        return roleDTO;
    }

}
