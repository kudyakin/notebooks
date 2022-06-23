package com.kudiukin.notebooks.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @Schema(description = "unique id of buyer", pattern = "sequence")
    private Integer id;

    @Schema(description = "name of buyer", example = "Petro")
    private String name;

    @Schema(description = "phone number of buyer", maxLength = 32)
    private Integer phone;

    @Schema(description = "email of buyer", maxLength =32)
    private String email;

    @Schema(hidden = true)
    @OneToOne(mappedBy = "mainBuyer")
    private Notebook notebook;

}
