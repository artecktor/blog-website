package com.example.BlogWebsite.Controller;

import org.springframework.ui.Model;
import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.CommentSaveDTO;
import com.example.BlogWebsite.DTO.UserSaveDTO;
import com.example.BlogWebsite.Model.*;
import com.example.BlogWebsite.Service.ApplicationUserService;
import com.example.BlogWebsite.Service.BlogService;
import com.example.BlogWebsite.Service.CommentService;
import com.example.BlogWebsite.Service.PageViewCounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {
    private final CommentService commentService;
    private final BlogService blogService;
    private final ApplicationUserService applicationUserService;
    private final PageViewCounterService pageViewCounterService;

    public PageController(BlogService blogService, ApplicationUserService applicationUserService, CommentService commentService, PageViewCounterService pageViewCounterService) {
        this.blogService = blogService;
        this.applicationUserService = applicationUserService;
        this.commentService = commentService;
        this.pageViewCounterService = pageViewCounterService;
    }

    @GetMapping
    public String home(Model model) {
        long views = pageViewCounterService.incrementAndGet();
        model.addAttribute("pageViews", views);
        return "home";
    }

    @GetMapping("/blog")
    public String blog() {
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
        return "redirect:/admin/blogs";
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
