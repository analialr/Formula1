package com.ironhack.edgeservice.controller.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConstructorDTO {
    public String constructorId;
    public String url;
    public String name;
    public String nationality;
}
