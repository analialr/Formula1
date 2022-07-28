package com.ironhack.edgeservice.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    public String lat;
    @JsonProperty("long") 
    public String mylong;
    public String locality;
    public String country;
}
