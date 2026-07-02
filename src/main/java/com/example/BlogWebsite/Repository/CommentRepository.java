package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public List<Comment> findByBlogId(int blogId);
    public List<Comment> findByUserId(int userId);
    public List<Comment> findByBlogIdAndAcceptedTrueOrderByUpdatedAtDesc(int blogId);
    public List<Comment> findAllByOrderByUpdatedAtDesc();
}
