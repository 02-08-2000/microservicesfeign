package com.UST.studentservicesfeign.conyroller;

import com.UST.studentservicesfeign.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="BOOK-SERVICE")
public interface BookRestController {
    @GetMapping("/book/data")
    public String getBookData();
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id);
    @GetMapping("/book/all")
    public List<Book> getAllBook();
    @GetMapping("/book/entity")
    public ResponseEntity<String> getEntityData();
}
