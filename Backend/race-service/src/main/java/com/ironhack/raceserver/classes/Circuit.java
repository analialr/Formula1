package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Circuit{
    public String circuitId;
    public String url;
    public String circuitName;
    @JsonProperty("Location") 
    public Location location;
}
