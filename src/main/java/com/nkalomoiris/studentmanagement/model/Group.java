package com.nkalomoiris.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group extends AbstractUpdatable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    public Group(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
