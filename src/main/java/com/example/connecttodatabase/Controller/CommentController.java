package com.example.connecttodatabase.Controller;

import com.example.connecttodatabase.DTO.CommentSaveDTO;
import com.example.connecttodatabase.Model.Comment;
import com.example.connecttodatabase.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment saveComment(@RequestBody CommentSaveDTO commentSaveDTO) { // برای ثبت نظرات مجبور شدم که تغییرش بدم
        Comment comment = commentSaveDTO.convertToComment();
        commentService.save(comment);
        return comment;
    }

    @PostMapping("/update")
    public Comment updateComment(CommentSaveDTO commentSaveDTO) {
        Comment comment = commentSaveDTO.convertToComment();
        commentService.update(comment);
        return comment;
    }

    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable int id) {
        Comment comment = commentService.findById(id);
        commentService.delete(comment);
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable int id) {
        return commentService.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<Comment> findByUserId(@PathVariable int id) {
        return commentService.findByUserId(id);
    }

    @GetMapping("/book/{id}")
    public List<Comment> findByBookId(@PathVariable int id) {
        return commentService.findByBookId(id);
    }

    @GetMapping("/book/{id}/sorted")
    public List<Comment> findByBookIdSorted(@PathVariable int id) {
        return commentService.findByBookIdAndAcceptedTrueOrderByUpdatedAtDesc(id);
    }
    @GetMapping("/sorted")
    public List<Comment> findAllSorted() {
        return commentService.findAllTrueOrderByUpdatedAtDesc();
    }

    @GetMapping
    public List<Comment> findAllComments() {
        return commentService.findAll();
    }
    @GetMapping("/accept/{id}")
    public void accept(@PathVariable int id) {
        commentService.accept(id);
    }
}
