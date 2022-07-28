package com.ironhack.raceserver.classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver{
    public String driverId;
    public String permanentNumber;
    public String code;
    public String url;
    public String givenName;
    public String familyName;
    public String dateOfBirth;
    public String nationality;
}
