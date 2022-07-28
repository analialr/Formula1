package com.ironhack.edgeservice.controller.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AverageSpeedDTO {
    public String units;
    public String speed;
}
