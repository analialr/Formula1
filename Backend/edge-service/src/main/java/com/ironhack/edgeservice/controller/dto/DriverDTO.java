package com.ironhack.edgeservice.controller.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    public String driverId;
    public String permanentNumber;
    public String code;
    public String url;
    public String givenName;
    public String familyName;
    public String dateOfBirth;
    public String nationality;
}
