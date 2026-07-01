package com.example.connecttodatabase.DTO;

import com.example.connecttodatabase.Model.Book;
import com.example.connecttodatabase.Model.Comment;

public class CommentSaveDTO {
    private int id;
    private String text;
    private int rating;
    private int bookId;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Comment convertToComment() {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setText(text);
        comment.setBookId(bookId);
        comment.setUserId(userId);
        comment.setRating(rating);
        return comment;
    }
}
