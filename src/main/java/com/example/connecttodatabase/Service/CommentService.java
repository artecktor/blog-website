package com.example.connecttodatabase.Service;

import com.example.connecttodatabase.Model.Book;
import com.example.connecttodatabase.Model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);
    void accept(int id);
    Comment findById(int id);
    List<Comment> findByUserId(int userId);
    List<Comment> findByBookId(int bookId);
    List<Comment> findAll();
    List<Comment> findByBookIdAndAcceptedTrueOrderByUpdatedAtDesc(int bookId);
    List<Comment> findAllTrueOrderByUpdatedAtDesc();
}
