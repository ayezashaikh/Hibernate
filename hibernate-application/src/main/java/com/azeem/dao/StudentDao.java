package com.azeem.dao;

import com.azeem.entity.Student;

public interface StudentDao {
    public void saveStudent(Student student);

    public Student loadStudent(int id);
}
