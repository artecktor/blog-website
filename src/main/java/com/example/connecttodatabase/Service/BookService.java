package com.example.connecttodatabase.Service;

import com.example.connecttodatabase.Model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void update(Book book);
    void delete(Book book);
    Book findById(int id);
    List<Book> findAll();
}
