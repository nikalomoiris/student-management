package com.nkalomoiris.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_first_name", nullable = false)
    @NotNull(message = "First name is mandatory")
    private String firstName;

    @Column(name = "student_last_name", nullable = false)
    @NotNull(message = "Last name is mandatory")
    private String lastName;

    @Column(name = "student_ssn", unique = true, nullable = false)
    @NotNull(message = "SSN is mandatory")
    @Size(min = 10, max = 10)
    private String ssn;

    @Column(name = "student_age")
    @Min(5)
    @Max(100)
    private Integer studentAge;

    @Column(name = "student_email")
    @Email
    private String email;

    @Column(name = "student_level")
    private Integer studentLevel; // TODO could be enum or separate entity

    @Column(name = "student_creation_date")
    private Date creationDate; // TODO check spring's feature to manage creation and update dates (auditing)

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
        this.creationDate = new java.util.Date(); // TODO this will be removed when spring's auditing is utilized
    }

}
