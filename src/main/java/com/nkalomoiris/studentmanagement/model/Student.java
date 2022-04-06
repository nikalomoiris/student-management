package com.nkalomoiris.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_first_name")
    private String firstName;

    @Column(name = "student_last_name")
    private String lastName;

    // TODO add a unique field e.g. A.M.

    @Column(name = "student_age")
    private Integer studentAge; // TODO add business like validation like (min, max, nullable)

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(Integer studentLevel) {
        this.studentLevel = studentLevel;
    }
}
