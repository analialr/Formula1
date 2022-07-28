package com.ironhack.edgeservice.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    public String number;
    public String position;
    public String positionText;
    public String points;
    @JsonProperty("Driver") 
    public DriverDTO driverDTO;
    @JsonProperty("Constructor") 
    public ConstructorDTO constructorDTO;
    public String grid;
    public String laps;
    public String status;
    @JsonProperty("Time") 
    public TimeDTO timeDTO;
    @JsonProperty("FastestLap") 
    public FastestLapDTO fastestLapDTO;
}
