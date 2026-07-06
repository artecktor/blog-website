package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.CommentSaveDTO;
import com.example.BlogWebsite.DTO.UserSaveDTO;
import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Blog;
import com.example.BlogWebsite.Model.Comment;
import com.example.BlogWebsite.Model.Role;
import com.example.BlogWebsite.Service.ApplicationUserService;
import com.example.BlogWebsite.Service.BlogService;
import com.example.BlogWebsite.Service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {
    private final CommentService commentService;
    private final BlogService blogService;
    ApplicationUserService applicationUserService;

    public PageController(BlogService blogService, ApplicationUserService applicationUserService, CommentService commentService) {
        this.blogService = blogService;
        this.applicationUserService = applicationUserService;
        this.commentService = commentService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/blog")
    public String book() {
        return "blog";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/users")
    public String saveUser(UserSaveDTO userSaveDTO) {
        ApplicationUser user = userSaveDTO.convertToApplicationUser();
        user.setRole(Role.USER);
        applicationUserService.save(user);
        return "redirect:/";
    }
    @PostMapping("/blogs")
    public String saveBlog(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.save(blog);
        return "adminBlog";
    }

    @PostMapping("/login")
    public String login(
            String email,
            String password,
            RedirectAttributes redirectAttributes
    ) {

        ApplicationUser user =
                applicationUserService.findByEmailAndPassword(email, password);

        if (user == null) {

            redirectAttributes.addFlashAttribute(
                    "loginError",
                    "ایمیل یا رمز عبور اشتباه است"
            );

            return "redirect:/login";
        }

        return "redirect:/";
    }
//    @PostMapping("/login")
//    public String login(String username, String password) {
//        ApplicationUser user = applicationUserService.findByEmailAndPassword(username, password);
//        if (user == null) {
//            return "login";
//        } else {
//            return "redirect:/";
//        }
//
//    }

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
    @GetMapping("/admin/blogs")
    public String adminBlogs() {
        return "adminBlog";
    }
    @GetMapping("/admin/blog-edit")
    public String adminBlogEdit() {
        return "adminBlogEdit";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @PostMapping("/comments/save")
    public String saveFromForm(CommentSaveDTO commentSaveDTO) {
        Comment comment = commentSaveDTO.convertToComment();
        commentService.save(comment);
        int blogId = comment.getBlogId();
        return "redirect:/blog?id=" + blogId;
    }
}
