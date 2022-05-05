package com.nkalomoiris.studentmanagement.dto.student;

public abstract class AbstractCreateStudentDto extends AbstractStudentDto{

  protected String ssn;

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }
}
