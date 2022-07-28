package com.ironhack.raceserver.classes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MRData{
    public String xmlns;
    public String series;
    public String url;
    public String limit;
    public String offset;
    public String total;
    @JsonProperty("RaceTable") 
    public RaceTable raceTable;
}
