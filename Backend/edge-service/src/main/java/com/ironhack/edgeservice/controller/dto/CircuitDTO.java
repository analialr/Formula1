package com.ironhack.edgeservice.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CircuitDTO {
    public String circuitId;
    public String url;
    public String circuitName;
    @JsonProperty("Location") 
    public LocationDTO locationDTO;
}
