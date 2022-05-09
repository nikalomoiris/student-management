package com.nkalomoiris.studentmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "group_name")
    private String Name;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private List<Student> students;

    @CreatedDate
    @Column(name = "group_creation_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "group_last_update_date")
    private LocalDateTime modifiedDate;

    @CreatedBy
    @Column(name = "group_created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "group_modified_by")
    private String modifiedBy;

    public Group(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", students=" + students +
                ", creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
