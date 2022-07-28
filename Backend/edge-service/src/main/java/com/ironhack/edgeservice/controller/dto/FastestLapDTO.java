package com.ironhack.edgeservice.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FastestLapDTO {
    public String rank;
    public String lap;
    @JsonProperty("Time") 
    public TimeDTO timeDTO;
    @JsonProperty("AverageSpeed") 
    public AverageSpeedDTO averageSpeedDTO;
}
