package com.azeem.controller;

import com.azeem.daoImpl.BookDao;
import com.azeem.entity.Author;
import com.azeem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestController {

    @Autowired
    BookDao bookDao;

    @PostMapping("/book")
    void saveBook(@RequestBody Book book) {
        bookDao.saveBook(book);

    }


    @GetMapping("/book")
    Book findBook( Integer bookId) {
        return bookDao.findBook(1001);
    }


    @DeleteMapping("/book")
    void remove(Integer bookId) {
        bookDao.remove(1001);
    }


}


/*
http://localhost:8045/book
* {
    "bookId": 1006,
    "bookName": "Sample Book 1",
    "authors": [
        {
            "authorId": 1008,
            "authorName": "Test Author 1 2"
        },
        {
            "authorId": 1002,
            "authorName": "Test Author  "
        }
    ]
}*/