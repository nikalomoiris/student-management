package com.nkalomoiris.studentmanagement.dto.group;

public abstract class AbstractCreateGroupDto extends AbstractGroupDto{

  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
