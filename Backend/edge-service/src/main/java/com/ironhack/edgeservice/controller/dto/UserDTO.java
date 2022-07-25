package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.classes.Driver;
import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String password;
    private Set<RoleDTO> roles;
    private Set<Driver> follows;
}
