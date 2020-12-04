package com.perflibnetcracker.searchservice.controller;

import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    private final BookService bookService;
    @Autowired
    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/service/search/find-all")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books-list";
    }

    @GetMapping("/api/service/search/book-create")
    public String createBookForm(Book book) {
        return "new_book";
    }

    @PostMapping("/api/service/search/book-create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/api/service/search/find-all";
    }

    @GetMapping("/api/service/search/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/api/service/search/book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/api/service/search/find-all";
    }

    @GetMapping("/api/service/search/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/api/service/search/book-update")
    public String updateBook(Book book){
        bookService.saveBook(book);
        return "redirect:/api/service/search/find-all";
    }
}
