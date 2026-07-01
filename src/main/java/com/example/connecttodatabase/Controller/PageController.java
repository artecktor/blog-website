package com.example.connecttodatabase.Controller;

import com.example.connecttodatabase.DTO.BookSaveDTO;
import com.example.connecttodatabase.DTO.UserSaveDTO;
import com.example.connecttodatabase.Model.ApplicationUser;
import com.example.connecttodatabase.Model.Book;
import com.example.connecttodatabase.Model.Role;
import com.example.connecttodatabase.Service.ApplicationUserService;
import com.example.connecttodatabase.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    BookService bookService;
    ApplicationUserService applicationUserService;

    public PageController(BookService bookService, ApplicationUserService applicationUserService) {
        this.bookService = bookService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/book")
    public String book() {
        return "bookDetail";
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
    public String saveBook(BookSaveDTO bookSaveDTO) {
        Book book = bookSaveDTO.convertToBook();
        bookService.save(book);
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
