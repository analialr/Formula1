package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaceDTO {
    public String season;
    public String round;
    public String url;
    public String raceName;
    @JsonProperty("Circuit") 
    public Circuit circuit;
    public String date;
    public String time;
    @JsonProperty("Results") 
    public ArrayList<Result> results;
}
