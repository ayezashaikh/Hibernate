package com.azeem.composite.key;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_student")
class Student {

    @EmbeddedId

    StudentCompositeKey id;

    @Column
    private String student_name;

    @Column
    private Integer marks;






    public StudentCompositeKey getId() {
        return id;
    }

    public void setId(StudentCompositeKey id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}