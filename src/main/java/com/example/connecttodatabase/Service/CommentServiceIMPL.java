package com.example.connecttodatabase.Service;

import com.example.connecttodatabase.Model.Comment;
import com.example.connecttodatabase.Repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceIMPL implements CommentService {
    final CommentRepository commentRepository;

    public CommentServiceIMPL(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Transactional
    @Override
    public void accept(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setAccepted(true);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByUserId(int userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public List<Comment> findByBookId(int bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByBookIdAndAcceptedTrueOrderByUpdatedAtDesc(int bookId) {
        return commentRepository.findByBookIdAndAcceptedTrueOrderByUpdatedAtDesc(bookId);
    }

    @Override
    public List<Comment> findAllTrueOrderByUpdatedAtDesc() {
        return commentRepository.findAllByOrderByUpdatedAtDesc();
    }


}
