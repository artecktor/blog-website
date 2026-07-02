package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);
    void accept(int id);
    Comment findById(int id);
    List<Comment> findByUserId(int userId);
    List<Comment> findByBlogId(int blogId);
    List<Comment> findAll();
    List<Comment> findByBlogIdAndAcceptedTrueOrderByUpdatedAtDesc(int blogId);
    List<Comment> findAllTrueOrderByUpdatedAtDesc();
}
