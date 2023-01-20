package com.crudlover.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record CarDTO(
    @NotBlank String model, 
    @NotBlank String manufacturer, 
    @Past String date, 
    @NotBlank double price, 
    @NotBlank int year
    ){
    
}
