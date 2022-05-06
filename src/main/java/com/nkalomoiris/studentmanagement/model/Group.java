package com.nkalomoiris.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nkalomoiris.studentmanagement.dto.student.GroupsStudentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group extends AbstractUpdatable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name")
    private String Name;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private List<Student> students;

    public Group(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
            "id=" + id +
            ", Name='" + Name + '\'' +
            ", students=" + students +
            '}';
    }
}
