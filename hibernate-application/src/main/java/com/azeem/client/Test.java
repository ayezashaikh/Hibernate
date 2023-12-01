package com.azeem.client;

import com.azeem.dao.StudentDao;
import com.azeem.dao.impl.StudentDaoImpl;
import com.azeem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {


    @Autowired
    StudentDao studentDao;

    @GetMapping("/test")
    public void test() {


        Student student = new Student();

        student.setSid(1234);
        student.setSname("Rahul");
        student.setGender("Male");
        student.setMarks(80);
        studentDao.saveStudent(student);
    }


    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable("id") int id) {
       return studentDao.loadStudent(id);

    }


}
