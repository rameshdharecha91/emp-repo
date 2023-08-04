package com.emp.controller;

import com.emp.model.Book;
import com.emp.model.Student;
import com.emp.response.Response;
import com.emp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value = "/books")
    public Book save(@RequestBody Book book){
        Book b = this.bookService.save(book);
        return b;
    }
}
