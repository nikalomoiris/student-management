package com.nkalomoiris.studentmanagement.dto.student;

import com.nkalomoiris.studentmanagement.dto.group.StudentsGroupDto;

public abstract class AbstractCreateStudentDto extends AbstractStudentDto{

  protected String ssn;

  protected StudentsGroupDto group;

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public StudentsGroupDto getGroup() {
    return group;
  }

  public void setGroup(StudentsGroupDto group) {
    this.group = group;
  }
}
