package com.example.connecttodatabase.Controller;

import com.example.connecttodatabase.DTO.BookSaveDTO;
import com.example.connecttodatabase.Model.Book;
import com.example.connecttodatabase.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/update")
    public String updateBook(BookSaveDTO bookSaveDTO) {
        Book book = bookSaveDTO.convertToBook();
        bookService.update(book);
        return "adminBook";
    }

    @GetMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return bookService.findById(id);
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }
}
