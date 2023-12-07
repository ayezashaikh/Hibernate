package com.azeem.client;

import com.azeem.dao.impl.StudentDao;
import com.azeem.entity.Student;
import jakarta.websocket.server.PathParam;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {


    @Autowired
    StudentDao studentDao;

    @PostMapping("/student")
    public String test() {
        Student student = new Student();
        student.setSid(1234);
        student.setSname("Rahul");
        student.setGender("Male");
        student.setMarks(80);
        studentDao.saveStudent(student);
        return "created successfully";
    }


    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable("id") int id) {
        return studentDao.loadStudent(id);

    }


    @DeleteMapping("/student/{sid}")
    public String deleteStudent(@PathVariable("sid") int sid) {
        studentDao.deleteStudent(sid);
        return "deleted successfully";
    }

    @PutMapping("/student/{sid}/{marks}")
    public String updateStudent(@PathVariable("sid") Integer sid, @PathVariable("marks") Integer marks) {
        System.out.println("sid:" + sid + "mark" + marks);
        studentDao.updateStudent(sid, marks);
        return "updated successfully";
    }




}
