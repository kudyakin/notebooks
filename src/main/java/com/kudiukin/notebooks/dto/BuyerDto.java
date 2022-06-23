package com.kudiukin.notebooks.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BuyerDto {

    @Schema(description = "name of buyer", example = "Petro")
    @Size(min = 2, max = 32, message = "Name of buyer must be between 2 and 32 characters")
    @NotNull (message = "Field must not be null")
    private String name;

    @Schema(description = "phone number of buyer", maxLength = 32)
    @NotNull (message = "Field must not be null")
    private Integer phone;

    @Schema(description = "email of buyer", maxLength =32)
    @NotNull (message = "Field must not be null")
    private String email;
}
