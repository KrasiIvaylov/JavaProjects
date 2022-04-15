package StudentsDataBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends User{
    private BigDecimal salary;
    private String email;
    private Set<Courses> courses;

    public Teacher() {
    }

    @Column
    public BigDecimal getPrice() {
        return salary;
    }

    public void setPrice(BigDecimal price) {
        this.salary = price;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "teacher")
    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }
}
