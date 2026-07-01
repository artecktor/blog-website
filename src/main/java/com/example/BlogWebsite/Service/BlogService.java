package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Blog;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    void update(Blog blog);
    void delete(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
}
