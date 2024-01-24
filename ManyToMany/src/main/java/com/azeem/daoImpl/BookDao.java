package com.azeem.daoImpl;

import com.azeem.entity.Book;

public interface BookDao{

    void saveBook(Book book);

    Book findBook(Integer bookId);

    void remove(Integer bookId);
}