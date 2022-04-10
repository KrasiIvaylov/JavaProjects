package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<ModelEntity> models;


    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}
