package com.nkalomoiris.studentmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    // TODO follow naming convention
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_first_name;
    private String student_last_name;
    // TODO add a unique field e.g. A.M.
    private Integer student_age; // TODO add business like validation like (min, max, nullable)
    private Integer student_level; // TODO could be enum or separate entity
    private Date student_creation_date; // TODO check spring's feature to manage creation and update dates (auditing)
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
        this.student_creation_date = new java.util.Date(); // TODO this will be removed when spring's auditing is utilized
    }

    public Date getStudent_creation_date() {
        return student_creation_date;
    }

    public void setStudent_creation_date(Date student_creation_date) {
        this.student_creation_date = student_creation_date;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_first_name() {
        return student_first_name;
    }

    public void setStudent_first_name(String student_first_name) {
        this.student_first_name = student_first_name;
    }

    public String getStudent_last_name() {
        return student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        this.student_last_name = student_last_name;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public Integer getStudent_level() {
        return student_level;
    }

    public void setStudent_level(Integer student_level) {
        this.student_level = student_level;
    }
}
