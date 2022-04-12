package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private Instant created;

    private Instant modified;
    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    @PrePersist
    public void beforeCreate(){
        this.created = Instant.now();
    }
    @PostPersist void onUpdate() {
        this.modified = Instant.now();
    }
}
