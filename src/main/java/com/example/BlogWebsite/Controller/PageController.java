package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.UserSaveDTO;
import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Role;
import com.example.BlogWebsite.Service.ApplicationUserService;
import com.example.BlogWebsite.Service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    BlogService blogService;
    ApplicationUserService applicationUserService;

    public PageController(BlogService blogService, ApplicationUserService applicationUserService) {
        this.blogService = blogService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/blog")
    public String book() {
        return "blog";
    }

    @GetMapping("/book-list")
    public String bookList() {
        return "books";
    }

    @GetMapping("/admin/books")
    public String adminBooks() {
        return "adminBook";
    }

    @GetMapping("/admin/book/save")
    public String saveBook() {
        return "saveBook";
    }

    @GetMapping("/admin/book/update")
    public String updateBook() {
        return "updateBook";
    }

    @PostMapping("/book/save")
    public String saveBook(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.save(blog);
        return "redirect:/admin/books";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/users")
    public String save(UserSaveDTO userSaveDTO) {
        ApplicationUser user = userSaveDTO.convertToApplicationUser();
        user.setRole(Role.USER);
        applicationUserService.save(user);
        return "home";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        ApplicationUser byUsernameAndPassword = applicationUserService.findByUsernameAndPassword(username, password);
        if (byUsernameAndPassword == null) {
            return "login";
        } else {
            return "redirect:";
        }

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        return "adminUser";
    }

    @GetMapping("/admin/comments")
    public String adminComments() {
        return "adminComment";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
