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
    public String updateBook(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBook();
        blogService.update(blog);
        return "adminBook";
    }

    @GetMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id) {
        return blogService.findById(id);
    }

    @GetMapping
    public List<Blog> findAllBooks() {
        return blogService.findAll();
    }
}
