package com.azeem.composite.key;

public interface StudentDao {
    Student saveStudent(Student student);
    Student fetchStudent(StudentCompositeKey compositeKey);

}
