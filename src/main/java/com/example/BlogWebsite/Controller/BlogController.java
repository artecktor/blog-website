package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/update")
    public void updateBlog(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.update(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id) {
        return blogService.findById(id);
    }

    @GetMapping
    public List<Blog> findAllBlogs() {
        return blogService.findAll();
    }
}
