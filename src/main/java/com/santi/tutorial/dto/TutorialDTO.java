package com.santi.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TutorialDTO {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;

}
