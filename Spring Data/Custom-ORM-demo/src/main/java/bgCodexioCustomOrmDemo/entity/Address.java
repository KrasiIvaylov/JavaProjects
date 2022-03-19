package bgCodexioCustomOrmDemo.entity;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

@Entity(tableName = "addresses")
public class Address {
    @Id
    private int id;

    @Column(name = "street", columnDefinition = "VARCHAR(255)")
    private String street;

    @Column(name = "street_number", columnDefinition = "VARCHAR(255)")
    private String streetNumber;

    @Column(name = "people_count", columnDefinition = "INT(11)")
    private int peopleCount;

}
