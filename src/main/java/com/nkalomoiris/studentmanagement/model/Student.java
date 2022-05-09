package com.nkalomoiris.studentmanagement.model;

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
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity(name = "students")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends AbstractUpdatable<Long> {

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
    private StudentLevel studentLevel;

    @CreatedDate
    @Column(name = "student_creation_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "student_last_update_date")
    private LocalDateTime modifiedDate;

    @CreatedBy
    @Column(name = "student_created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "student_modified_by")
    private String modifiedBy;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", ssn='" + ssn + '\'' +
            ", studentAge=" + studentAge +
            ", email='" + email + '\'' +
            ", studentLevel=" + studentLevel +
            ", creationDate=" + creationDate +
            ", modifiedDate=" + modifiedDate +
            ", groupId=" + group.getId() +
            ", groupName=" + group.getName() +
            '}';
    }
}
