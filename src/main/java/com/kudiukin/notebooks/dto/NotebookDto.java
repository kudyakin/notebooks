package com.kudiukin.notebooks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class NotebookDto {

    @JsonIgnore
    public Integer id;

    @NotNull
    @Size(min = 2, max = 32, message = "NameBrand must be between 2 and 32 characters long")
    @Schema(description = "Brand name of notebook.", example = "Lenovo", required = true)
    public String nameBrand;

    @NotNull
    @Size(min = 2, max = 32, message = "Model must be between 2 and 32 characters long")
    @Schema(description = "Model of notebook.", example = "X100", required = true)
    public String model;

    @NotNull
    @Schema(description = "Display diagonal of notebook.", example = "14", required = true)
    public int displayDiagonal;

    @Size(min = 2, max = 32, message = "Processor must be between 2 and 32 characters long")
    @Schema(description = "Processor of notebook.", example = "i5", required = true)
    public String processor;

    @NotNull
    @Schema(description = "Memory size of notebook.", example = "8", required = true)
    public int memorySize;

    @NotNull
    @Schema(description = "SSD size of notebook.", example = "240", required = true)
    public int ssdSize;

    @Size(min = 2, max = 32, message = "Videocard must be between 2 and 32 characters long")
    @Schema(description = "Videocard of notebook.", example = "GeForce 2470 2Gb", required = true)
    public String videocard;

    @Size(min = 2, max = 12, message = "Operating system must be between 2 and 12 characters long")
    @Schema(description = "Operating system of notebook.", example = "Win10", required = true)
    public String os;

    @NotNull
    @Schema(description = "Produse date of notebook.", example = "2020-10-16", required = true)
    public LocalDate produceDate;

    @JsonIgnore
    public Boolean isDeleted = Boolean.FALSE;

    @JsonIgnore
    @Schema
    public BuyerDto mainBuyer;
}
