package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name ="models")
public class ModelEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private Integer startYear;
    private Integer endYear;
    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }
    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrand() {
        return brand;
    }
    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
