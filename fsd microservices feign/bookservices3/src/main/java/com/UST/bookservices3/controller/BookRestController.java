package com.UST.bookservices3.controller;

import com.UST.bookservices3.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;
    @GetMapping("/data")
    public String getBookData() {
        return "data of BOOK-SERVICE,Running on port:" +environment.getProperty("local.service.port");
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return new Book(id,"Head First Java",500.75);
    }
    @GetMapping("/all")
    public List<Book> getAll(){
        return List.of(new Book(501,"Head First Java",439.75),
                new Book(502,"Spring in Action",340.75),
                new Book(503,"Hibernate in Action",355.75));
    }
    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData(){
        return new ResponseEntity<String>("hello from BookRestController",HttpStatus.OK);
    }
}
