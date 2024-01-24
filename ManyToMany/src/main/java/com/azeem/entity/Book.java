package com.azeem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_books")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "bookId")
public class Book implements Serializable {

    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;


    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_books_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id" , referencedColumnName = "author_id"))
    private List<Author> authors;


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authors=" + authors +
                '}';
    }
}
 