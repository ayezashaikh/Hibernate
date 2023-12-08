package com.azeem.composite.key;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;


    @PostMapping("/student")
    Student saveStudent(@RequestBody Student student) throws JsonProcessingException {

       /* student = new Student();
        StudentCompositeKey studentCompositeKey = new StudentCompositeKey();
        studentCompositeKey.setRollNumber(11000);
        studentCompositeKey.setSection("A");

        student.setId(studentCompositeKey);
        student.setStudent_name("Rahul");
        student.setMarks(100);


        String s = new ObjectMapper().writeValueAsString(student);

        System.out.println(s);*/

        return studentDao.saveStudent(student);
    }


    @GetMapping("/student/{rollNumber}/{section}")
    Student fetchStudent(@PathVariable("rollNumber") int rollNumber, @PathVariable("section") String section) {
        StudentCompositeKey compositeKey = new StudentCompositeKey();
        compositeKey.setRollNumber(rollNumber);
        compositeKey.setSection(section);
        return studentDao.fetchStudent(compositeKey);
    }


    public static void main(String[] args) throws JsonProcessingException {
        StudentController studentController =  new StudentController();

        studentController.saveStudent(new Student());
    }
}
