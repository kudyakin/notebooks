package com.kudiukin.notebooks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class NotebookDto {

    public Integer id;

    @NotNull
    @Size(min = 2, max = 32, message = "NameBrand must be between 2 and 32 characters long")
    public String nameBrand;

    @NotNull
    @Size(min = 2, max = 32, message = "Model must be between 2 and 32 characters long")
    public String model;

    @NotNull
    public int displayDiagonal;

    @Size(min = 2, max = 32, message = "Processor must be between 2 and 32 characters long")
    public String processor;

    @NotNull
    public int memorySize;

    @NotNull
    public int ssdSize;

    @Size(min = 2, max = 32, message = "Videocard must be between 2 and 32 characters long")
    public String videocard;

    @Size(min = 2, max = 12, message = "Operating system must be between 2 and 12 characters long")
    public String os;

    @NotNull
    public LocalDate produceDate;

    @JsonIgnore
    public Boolean isDeleted = Boolean.FALSE;
}
