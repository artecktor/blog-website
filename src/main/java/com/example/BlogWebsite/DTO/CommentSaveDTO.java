package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Comment;

public class CommentSaveDTO {
    private int id;
    private String text;
    private int rating;
    private int blogId;
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

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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
        comment.setBlogId(blogId);
        comment.setUserId(userId);
        comment.setRating(rating);
        return comment;
    }
}
