package amb.poc.excelwork.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "city")
    private String city;
}
