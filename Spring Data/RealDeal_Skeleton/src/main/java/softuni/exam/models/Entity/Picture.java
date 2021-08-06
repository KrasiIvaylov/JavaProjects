package softuni.exam.models.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "picture")
public class Picture extends BaseEntity{
    private String name;
    private LocalDateTime dateAndTime;
    private Car car;

    public Picture() {
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
