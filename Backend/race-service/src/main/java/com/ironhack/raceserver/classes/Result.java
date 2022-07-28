package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result{
    public String number;
    public String position;
    public String positionText;
    public String points;
    @JsonProperty("Driver") 
    public Driver driver;
    @JsonProperty("Constructor") 
    public Constructor constructor;
    public String grid;
    public String laps;
    public String status;
    @JsonProperty("Time") 
    public Time time;
    @JsonProperty("FastestLap") 
    public FastestLap fastestLap;
}
