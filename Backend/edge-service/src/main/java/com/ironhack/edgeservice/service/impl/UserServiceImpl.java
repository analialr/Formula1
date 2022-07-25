package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.controller.dto.FollowDTO;
import com.ironhack.edgeservice.controller.dto.RoleDTO;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.Follow;
import com.ironhack.edgeservice.model.Role;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.repository.FollowRepository;
import com.ironhack.edgeservice.repository.UserRepository;
import com.ironhack.edgeservice.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO store(UserDTO userDTO) {
        logger.info(userDTO.toString());
        User user = toModel(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Set default profile
        user.setRoles(Set.of(new Role(null, "USER", user)));
        User savedUser = userRepository.save(user);
        savedUser.setPassword(null);
        return toDTO(savedUser);
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> response = users.stream().map(this::toDTO).toList();

        return response;
    }

    private User toModel(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(this::roleToDTO).collect(Collectors.toSet()));
        userDTO.setFollows(user.getFollows().stream().map(this::followToDTO).collect(Collectors.toSet()));

        return userDTO;
    }

    private RoleDTO roleToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());

        return roleDTO;
    }

    private FollowDTO followToDTO(Follow follow) {
        FollowDTO followDTO = new FollowDTO();
        followDTO.setDriver(follow.getDriver());

        return followDTO;
    }

    public FollowDTO follow(Long userId, String driverId){
        Optional<User> user = userRepository.findById(userId);
        Follow follow = new Follow();
        follow.setUser(user.get());
        follow.setDriver(driverId);
        followRepository.save(follow);
        return followToDTO(follow);
    }
}
