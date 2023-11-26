package com.softserve.edu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@With
public class AddDto {

    //@Size(min = 1, max = 5, message = "first value should be between 1 and 5 digits")
    //@NotBlank(message = "firstname cannot be empty")
    private String firstValue;

    //@Size(min = 1, max = 5, message = "second value should be between 1 and 5 digits")
    //@NotBlank(message = "firstname cannot be empty")
    private String secondValue;

    private String result;
}
