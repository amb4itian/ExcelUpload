package amb.poc.excelwork.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:MM")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy HH:MM")
    private Date dob;

    @Column(name = "city")
    private String city;

    Student(Integer id, String firstName, String lastName, Date dob, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.city = city;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private Integer id;
        private String firstName;
        private String lastName;
        private Date dob;
        private String city;

        public StudentBuilder() {
        }

        public StudentBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder dob(Date dob) {
            this.dob = dob;
            return this;
        }

        public StudentBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Student build() {
            return new Student(id, firstName, lastName, dob, city);
        }

        public String toString() {
            return "Student.StudentBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", dob=" + this.dob + ", city=" + this.city + ")";
        }
    }
}
