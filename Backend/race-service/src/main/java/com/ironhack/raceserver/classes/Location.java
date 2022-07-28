package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location{
    public String lat;
    @JsonProperty("long") 
    public String mylong;
    public String locality;
    public String country;
}
