package com.azeem.dao.impl;

import com.azeem.entity.Student;

public interface StudentDao {
    void saveStudent(Student student);

    Student loadStudent(int id);

    Student updateStudent(int side, int marks);

    void deleteStudent(int sid);
}
