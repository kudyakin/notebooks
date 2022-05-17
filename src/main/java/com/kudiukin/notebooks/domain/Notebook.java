package com.kudiukin.notebooks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "notebooks")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nameBrand;
    private String model;
    private int displayDiagonal;
    private String processor;
    private int memorySize;
    private int ssdSize;
    private String videocard;
    private String os;
    private LocalDate produceDate;
    @JsonIgnore
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplayDiagonal() {
        return displayDiagonal;
    }

    public void setDisplayDiagonal(int displayDiagonal) {
        this.displayDiagonal = displayDiagonal;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getSsdSize() {
        return ssdSize;
    }

    public void setSsdSize(int ssdSize) {
        this.ssdSize = ssdSize;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public LocalDate getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(LocalDate produceDate) {
        this.produceDate = produceDate;
    }

    @JsonIgnore
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook)) return false;
        Notebook notebook = (Notebook) o;
        return getDisplayDiagonal() == notebook.getDisplayDiagonal() && getMemorySize() == notebook.getMemorySize() && getSsdSize() == notebook.getSsdSize() && getId().equals(notebook.getId()) && getNameBrand().equals(notebook.getNameBrand()) && getModel().equals(notebook.getModel()) && getProcessor().equals(notebook.getProcessor()) && getVideocard().equals(notebook.getVideocard()) && getOs().equals(notebook.getOs()) && getProduceDate().equals(notebook.getProduceDate()) && isDeleted.equals(notebook.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameBrand(), getModel(), getDisplayDiagonal(), getProcessor(), getMemorySize(), getSsdSize(), getVideocard(), getOs(), getProduceDate(), isDeleted);
    }
}