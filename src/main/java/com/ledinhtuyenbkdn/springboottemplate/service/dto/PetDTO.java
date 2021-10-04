package com.ledinhtuyenbkdn.springboottemplate.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String type;
}
