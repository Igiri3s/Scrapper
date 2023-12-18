package com.example.Scraper.controllers;

import com.example.Scraper.models.Book;
import com.example.Scraper.services.BooksServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("library")
public class BookController {

    BooksServiceImp booksServiceImp;

    @Autowired
    public BookController(BooksServiceImp booksServiceImp) {
        this.booksServiceImp = booksServiceImp;
    }

    @GetMapping("/getAll")
    List<Book> getAllBorrows() {
        return booksServiceImp.returnAllBooks();
    }
}
