package com.azeem.composite.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCompositeKey implements Serializable
{
  
  @Column(name="ROLL_NO")
  private Integer rollNumber;

  @Column(name="section")
  private String section;


  public Integer getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(Integer rollNumber) {
    this.rollNumber = rollNumber;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public StudentCompositeKey() {
  }

  @Override
  public String toString() {
    return "StudentCompositeKey{" +
            "rollNumber=" + rollNumber +
            ", section='" + section + '\'' +
            '}';
  }
}