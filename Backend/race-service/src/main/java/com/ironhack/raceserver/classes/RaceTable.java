package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaceTable{
    public String season;
    public String round;
    @JsonProperty("Races") 
    public ArrayList<RaceDTO> races;
}
