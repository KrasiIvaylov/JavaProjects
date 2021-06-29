package bgCodexioCustomOrmDemo.entity;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.time.LocalDate;

@Entity(tableName = "users")
public class User {
    @Id
    private int id;
    @Column(name = "username", columnDefinition = "VARCHAR(100)")
    private String username;
    @Column(name = "age", columnDefinition = "INT")
    private int age;
    @Column(name = "registration", columnDefinition = "DATE")
    private LocalDate registration;

    public User(){};

    public User(String username, int age) {
        this.username = username;
        this.age = age;
        this.registration = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }
}
