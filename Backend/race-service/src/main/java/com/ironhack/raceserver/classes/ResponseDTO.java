package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    @JsonProperty("MRData") 
    public MRData mRData;
}
