package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceIMPL implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceIMPL(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
