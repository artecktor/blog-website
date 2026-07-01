package com.example.connecttodatabase.Repository;

import com.example.connecttodatabase.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByBookId(int bookId);
    public List<Comment> findByUserId(int userId);
    public List<Comment> findByBookIdAndAcceptedTrueOrderByUpdatedAtDesc(int bookId);
    public List<Comment> findAllByOrderByUpdatedAtDesc();
}
