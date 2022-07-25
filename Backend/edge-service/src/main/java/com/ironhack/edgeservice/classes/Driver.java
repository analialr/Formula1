package com.ironhack.edgeservice.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {

    private String driverId;
    private String givenName;
    private String familyName;
    private Date dateOfBirth;
    private String nationality;
    private String url;

}
