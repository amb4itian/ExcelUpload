package amb.poc.excelwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * Custom Id generator
 */

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @Column(name = "employee_id", length = 100)
    @GenericGenerator(name = "employee_id",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "EMP"),
            strategy = "amb.poc.excelwork.CustomIdGenerator")
    @GeneratedValue(generator = "employee_id")
    private String employeeId;

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
