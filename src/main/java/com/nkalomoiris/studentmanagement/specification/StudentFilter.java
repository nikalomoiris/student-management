package com.nkalomoiris.studentmanagement.specification;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentFilter {

    private String firstName;

    private String lastName;

    private String ssn;

    private Integer studentAge;

    private String email;

}
