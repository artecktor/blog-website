package com.example.connecttodatabase.DTO;

import com.example.connecttodatabase.Model.Book;

public class BookSaveDTO {
    private int id;
    private String title;
    private String author;
    private String description;
    private int price;
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

    public void setAuthor(String author) {this.author = author;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {return price;}

    public void setPrice(int price) {
        this.price = price;
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

    public Book convertToBook() {
        Book book = new Book();
        book.setId(id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setDescription(this.description);
        book.setPrice(this.price);
        book.setImageAddress(this.imageAddress);
        return book;
    }
}
