package amb.poc.excelwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @Column(name = "employeeId")
    @GenericGenerator(name = "id-gen",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "EMP"),
            strategy = "amb.poc.excelwork.CustomIdGenerator")
    private String employee_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "joiningDate")
    private Date joiningDate;

    @Column(name = "city")
    private String city;
}
