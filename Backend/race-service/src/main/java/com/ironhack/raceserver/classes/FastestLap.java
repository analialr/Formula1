package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FastestLap{
    public String rank;
    public String lap;
    @JsonProperty("Time") 
    public Time time;
    @JsonProperty("AverageSpeed") 
    public AverageSpeed averageSpeed;
}
