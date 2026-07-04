package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.Blog;

public class BlogSaveDTO {
    private int id;
    private String title;
    private String author;
    private String content;
    private String description;
    private String imageAddress;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {this.author = author;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog convertToBlog() {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle(this.title);
        blog.setAuthor(this.author);
        blog.setDescription(this.description);
        blog.setImageAddress(this.imageAddress);
        blog.setContent(this.content);
        return blog;
    }
}
