package com.azeem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tbl_authors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "authorId")
public class Author implements Serializable {

    @Id
    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;



    @ManyToMany(cascade =  CascadeType.ALL, mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Book> books;


    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}