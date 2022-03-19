package com.example.dtoExercise.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer
            , String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    //Title validation with regex
    @Pattern(regexp = "[A-Z].[a-z]{6,100}",message = "Please enter valid title!")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Price validation
    @DecimalMin(value = "0",message = "Please enter valid price!")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //Validation positive price
    @Positive
    public Double getSize() {
        return size;
    }
    public void setSize(Double size) {
        this.size = size;
    }

    //Trailer validation
    @Size(min = 11, max = 11 ,message = "Please enter valid trailer!")
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    //URL validation with regex
    @Pattern(regexp = "(https?).+",message = "Please enter valid URL!")
    public String getThumbnailURL() {
        return thumbnailURL;
    }
    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    //Description validation
    @Size(min = 20 ,message = "Please enter valid description!")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date")
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
