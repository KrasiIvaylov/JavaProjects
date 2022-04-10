package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
<<<<<<< HEAD
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
=======


    @OneToMany(cascade = CascadeType.ALL)
>>>>>>> 1680181ce1fae65f1a6acfd578914d18eddd3188
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
